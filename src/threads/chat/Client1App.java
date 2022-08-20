package threads.chat;

import threads.chat.client.Client;

public class Client1App {
    public static void main(String[] args) {
        Client chat = new Client("User");
        chat.exec();
    }
}
