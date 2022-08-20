package threads.chat.client;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;

public class ChatLayer extends JPanel {

    private int width;

    private int height;

    private String username;

    public ChatLayer(int width, int height, String username) {
        this.width = width;
        this.height = height;
        this.username = username;
        this.onInit();
    }

    public void onInit() {
        this.setBackground(new Color(20, 195, 142));
        this.setLayout(new BorderLayout(0, 10));
        this.setBorder(new EmptyBorder(0, 10, 10, 10));

        Header title = new Header(this.username, SwingConstants.CENTER);
        this.add(title, BorderLayout.NORTH);

        // Display
        ChatDisplay screen = new ChatDisplay();
        JScrollPane scroll = new JScrollPane(screen);
        this.add(scroll, BorderLayout.CENTER);


        // Controls
        JPanel controls = new JPanel(new FlowLayout());

        InputField message = new InputField("", 15);
        message.setDocument(new JTextFieldLimit(24));
        message.setText("Message (max 24 chars)");
        controls.add(message);



        JButton send = new JButton("Send") {
            @Override
            public void doLayout() {
                super.doLayout();
                this.requestFocusInWindow();
            }
        };
        send.addActionListener(new MessageSent(screen, message, scroll));

        controls.setOpaque(false);
        controls.add(send);
        this.add(controls, BorderLayout.SOUTH);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(this.width, this.height);
    }

    // Inner classes of main layer
    class Header extends JLabel {

        public Header(String text, int horizontalAlignment) {
            super(text, horizontalAlignment);
            this.setBorder(new EmptyBorder(10, 0, 0, 0));
            this.setFont(new Font("Arial", Font.BOLD, 20));
        }
    }
}

