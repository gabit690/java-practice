package threads.chat.server;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ServerLayer extends JPanel {

    private int width;

    private int height;

    public ServerLayer(int width, int height) {
        this.width = width;
        this.height = height;
        this.onInit();
    }

    private void onInit() {
        this.setLayout(new BorderLayout());
        this.setBorder(new EmptyBorder(0, 0, 0, 0));

        ServerDisplay console = new ServerDisplay();
        JScrollPane scrollPanel = new JScrollPane(console);
        this.add(scrollPanel);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(this.width, this.height);
    }
}
