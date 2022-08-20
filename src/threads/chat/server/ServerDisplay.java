package threads.chat.server;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.LinkedList;

public class ServerDisplay extends JPanel {

    private LinkedList<JLabel> messages = new LinkedList<>();

    public ServerDisplay() {
        this.setBackground(Color.BLACK);
        this.setBorder(new EmptyBorder(0, 0, 0, 0));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(new EmptyBorder(0, 0, 0, 0));


        for (int message = 1; message <= 12; message++) {
            JLabel m = new JLabel("MESSAGE --> MESSAGE");
            m.setOpaque(false);
            m.setForeground(Color.GREEN);
            m.setBorder(new EmptyBorder(10, 20, 0, 0));
            this.add(m);
        }

    }

    public void addNewMessage(JLabel message) {
        this.messages.add(message);
        this.add(message);
    }



}
