package threads.chat.server;

import javax.swing.*;
import java.awt.*;

public class Server extends JFrame {

    private int portServer;

    public Server(int portServer) {
        this.portServer = portServer;
        this.onInit();
    }

    private void onInit() {
        this.setTitle("Chat Server");
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("src/threads/chat/icon.png"));
        this.add(new ServerLayer(400, 300, this.portServer));

        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
    }

    public void exec() {
        this.setVisible(true);
    }
}
