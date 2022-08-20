package threads.chat.client;

import threads.chat.Message;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.LinkedList;

public class ChatDisplay extends JPanel{

    private LinkedList<Message> messages = new LinkedList<>();

    public ChatDisplay() {
        this.setBackground(new Color(227, 252, 191));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(new EmptyBorder(5, 3, 5,  3));

        if (this.messages.size() <= 6) {
            JPanel p1 = new JPanel();
            p1.setOpaque(false);
            add(p1);
        }
    }

    public void addNewMessage(Message message) {
        this.messages.add(message);
        this.add(message);
    }

}
