package threads.chat;

import threads.chat.client.Client;

public class Client2App {
    public static void main(String[] args) {
        Client chat = new Client("User-B",  9999, 5000, 8081);
        chat.exec();
    }
}
