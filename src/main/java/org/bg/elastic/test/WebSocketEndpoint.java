package org.bg.elastic.test;

import org.apache.logging.log4j.Logger;
import org.elasticsearch.common.logging.Loggers;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/_changes")
public class WebSocketEndpoint {

    private final Logger log = Loggers.getLogger(WebSocketEndpoint.class);
    private Session session;

    @OnOpen
    public void onOpen(Session session) {
        log.info("Connected ... " + session.getId());
        this.session = session;
        ChangesFeedPlugin.getRegister().registerListener(this);
    }

    public void sendMessage(String message) {
        session.getAsyncRemote().sendText(message);
    }

    public String getId() {
        return session == null ? null : session.getId();
    }

    @OnMessage
    public void onMessage(String message) {
        log.info("Received message: "+message);
    }

    @OnClose
    public void onClose(CloseReason reason) {
        log.info("Closing websocket: "+reason);
        ChangesFeedPlugin.getRegister().unregisterListener(this);
        this.session = null;
    }

    @OnError
    public void onError(Throwable t) {
        log.error("Error on websocket "+(session == null ? null : session.getId()), t);
    }


}
