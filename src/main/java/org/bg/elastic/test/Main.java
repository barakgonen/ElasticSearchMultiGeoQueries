package org.bg.elastic.test;

import jakarta.websocket.DeploymentException;
import org.glassfish.tyrus.client.ClientManager;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args){
        System.out.println("BGBG");
        CountDownLatch latch = new CountDownLatch(1);
        try {
            System.out.println("Trying to connect es");
            ClientManager client = ClientManager.createClient();
            client.connectToServer(WebSocketClient.class, new URI("ws://localhost:9400/ws/_changes"));
            System.out.println("Connected!");
            latch.await();
        } catch (DeploymentException | IOException | URISyntaxException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
