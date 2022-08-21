package threads.chat.server;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.LinkedList;

public class ServerDisplay extends JPanel {

    private LinkedList<JLabel> messages = new LinkedList<>();

    public ServerDisplay() {
        this.setBackground(Color.BLACK);
        this.setBorder(new EmptyBorder(10, 0, 10, 0));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

    }

    public void addNewMessage(JLabel message) {
        this.messages.add(message);
        message.setOpaque(false);
        message.setForeground(Color.GREEN);
        message.setBorder(new EmptyBorder(10, 20, 0, 0));
        this.add(message);
    }
}
