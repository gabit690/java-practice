package threads.chat.client;

import threads.chat.Message;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ClientSendMessage implements ActionListener {

    private ChatDisplay panel;

    private InputField input;

    private JScrollPane scroll;

    public ClientSendMessage(ChatDisplay panel, InputField input, JScrollPane scroll) {
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
        }
    }
}
