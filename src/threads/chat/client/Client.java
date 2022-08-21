package threads.chat.client;

import javax.swing.*;
import java.awt.*;

public class Client extends JFrame {

    private int width = 300;

    private int height = 350;

    private String username;

    private int portEmitter;

    private int portServer;

    private int portReceptor;

    public Client(String username, int portEmitter, int portServer, int portReceptor) {
        this.username = username;
        this.portEmitter = portEmitter;
        this.portServer = portServer;
        this.portReceptor = portReceptor;
        this.onInit();
    }

    public void exec() {
        this.setVisible(true);
    }

    private void onInit() {
        this.setTitle("Chat App");
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("src/threads/chat/icon.png"));
        this.add(new ChatLayer(this.width, this.height, this.username, this.portEmitter, this.portServer, this.portReceptor));
        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
    }
}