package farkle;

import org.java_websocket.server.WebSocketServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.InetSocketAddress;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        // Starting application server
        SpringApplication.run(Application.class, args);
        System.out.println("Application start successful");

        // Starting the websocket server
        String host = "localhost";
        int port = 8001;

        WebSocketServer server = new SocketServer(new InetSocketAddress(host, port));
        server.run();
        System.out.println("Websocket server start successful");
    }
}
