package threads.chat.client;

import javax.swing.*;
import java.awt.*;

public class Client extends JFrame {

    private String username;

    private int width = 300;

    private int height = 350;

    public Client(String username) {
        this.username = username;
        this.onInit();
    }

    public void exec() {
        this.setVisible(true);
    }

    private void onInit() {
        this.setTitle("Chat App");
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("src/threads/chat/icon.png"));
        this.add(new ChatLayer(this.width, this.height, this.username));
        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
    }
}