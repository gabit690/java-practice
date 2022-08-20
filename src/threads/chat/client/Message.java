package threads.chat.client;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Message extends JPanel {

    private String author;

    private String content;

    private boolean isEmitter;

    public Message(String author, String content, boolean isEmitter) {

        this.author = author;
        this.content = content;
        this.isEmitter = isEmitter;

        setLayout(new FlowLayout( isEmitter ? FlowLayout.RIGHT : FlowLayout.LEFT));
        this.setOpaque(false);
        JLabel message1 = new JLabel(content);
        message1.setBorder(new EmptyBorder(5, 10, 5, 10));
        message1.setBackground(isEmitter ? new Color(0, 255, 171) : new Color(184, 241, 176));
        message1.setOpaque(true);
        add(message1);
        this.setMaximumSize(new Dimension(Integer.MAX_VALUE, this.getPreferredSize().height));
    }

    @Override
    public String toString() {
        return "Message{" +
                "author='" + author + '\'' +
                ", content='" + content + '\'' +
                ", isEmitter=" + isEmitter +
                '}';
    }
}

class MessageSent implements ActionListener {

    private ChatDisplay panel;

    private InputField input;

    private JScrollPane scroll;

    public MessageSent(ChatDisplay panel, InputField input, JScrollPane scroll) {
        this.panel = panel;
        this.input = input;
        this.scroll = scroll;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (input.getForeground() == Color.LIGHT_GRAY) {
            System.out.println("NONE");
        }
        if (input.getForeground() == Color.BLACK) {
            panel.addNewMessage(new Message("Me", input.getText(), true));

            panel.revalidate();
            input.reset();
            panel.repaint();

            scroll.validate();
            scroll.repaint();
            JScrollBar vertical = scroll.getVerticalScrollBar();
            vertical.setValue( vertical.getMaximum() );
            // TODO: Repaint Chat panel
        }
    }
}