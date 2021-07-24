package org.bg.elastic.test;

import javax.websocket.*;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

@jakarta.websocket.ClientEndpoint
public class WebSocketClient {
    private static CountDownLatch latch;

    @OnOpen
    public void onOpen(Session session){
        System.out.println("Connected ... " + session.getId());

        try {
            session.getBasicRemote().sendText("statrt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @OnMessage
    public void onMessage(String message, Session session){
        System.out.println("Received: " + message);
    }

    @OnClose
    public void onClose(Session session, CloseReason reason){
        System.out.println("disconnected");
    }
}
