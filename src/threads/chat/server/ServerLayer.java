package threads.chat.server;

import javax.swing.*;
import java.awt.*;

public class ServerLayer extends JPanel {

    private int width;

    private int height;

    private int portServer;

    public ServerLayer(int width, int height, int portServer) {
        this.width = width;
        this.height = height;
        this.portServer = portServer;
        this.onInit();
    }

    private void onInit() {
        this.setLayout(new BorderLayout());

        ServerDisplay console = new ServerDisplay();

        JScrollPane scrollPanel = new JScrollPane(console);
        this.add(scrollPanel);

        Thread t = new Thread(new ServerMessageReceived(console, scrollPanel, this.portServer));
        t.start();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(this.width, this.height);
    }
}
