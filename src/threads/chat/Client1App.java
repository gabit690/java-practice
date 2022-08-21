package threads.chat;

import threads.chat.client.Client;

public class Client1App {
    public static void main(String[] args) {
        Client chat = new Client("User-A",  8081, 5000, 9999);
        chat.exec();
    }
}
