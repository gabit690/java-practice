package threads.chat.client;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ChatLayer extends JPanel {

    private int width;

    private int height;

    private String emitter;

    private int portEmitter;

    private int portServer;

    private int portReceptor;

    public ChatLayer(int width, int height, String emitter, int portEmitter, int portServer, int portReceptor) {
        this.width = width;
        this.height = height;
        this.emitter = emitter;
        this.portEmitter = portEmitter;
        this.portServer = portServer;
        this.portReceptor = portReceptor;
        this.onInit();
    }

    public void onInit() {
        this.setBackground(new Color(20, 195, 142));
        this.setLayout(new BorderLayout(0, 10));
        this.setBorder(new EmptyBorder(0, 10, 10, 10));

        Header title = new Header(this.emitter, SwingConstants.CENTER);
        this.add(title, BorderLayout.NORTH);

        // Display
        ChatDisplay screen = new ChatDisplay();
        JScrollPane scroll = new JScrollPane(screen);
        this.add(scroll, BorderLayout.CENTER);


        // Controls
        JPanel controls = new JPanel(new FlowLayout());

        InputField message = new InputField("", 15);
        message.addKeyListener(new AddFromInput(screen, message, scroll, this.emitter, this.portEmitter, this.portServer, this.portReceptor));
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
        send.addActionListener(new ClientSendMessage(screen, message, scroll, this.emitter, this.portEmitter, this.portServer, this.portReceptor));

        controls.setOpaque(false);
        controls.add(send);
        this.add(controls, BorderLayout.SOUTH);

        ClientReceivedMessage listenerMessages = new ClientReceivedMessage(screen, scroll, this.portEmitter);
        listenerMessages.start();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(this.width, this.height);
    }

}

