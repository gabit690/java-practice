package threads.chat;

import threads.chat.server.Server;

public class ServerApp {
    public static void main(String[] args) {
        Server appServer = new Server();
        appServer.exec();
    }
}
