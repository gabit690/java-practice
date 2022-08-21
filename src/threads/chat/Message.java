package threads.chat;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

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
        message1.setBackground(isEmitter ? new Color(0, 255, 171) : Color.DARK_GRAY);
        message1.setForeground(isEmitter ? Color.BLACK : Color.WHITE);
        message1.setOpaque(true);
        add(message1);
        this.setMaximumSize(new Dimension(Integer.MAX_VALUE, this.getPreferredSize().height));
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isEmitter() {
        return isEmitter;
    }

    public void setEmitter(boolean emitter) {
        isEmitter = emitter;
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
