package threads.chat.client;

import threads.chat.Message;
import threads.chat.MessageDataTransfer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class AddFromInput extends KeyAdapter {

    private ChatDisplay panel;

    private InputField input;

    private JScrollPane scroll;

    private String emitter;

    private int portOutput;

    private int portServer;

    private int portReceptor;

    public AddFromInput(ChatDisplay panel, InputField input, JScrollPane scroll, String emitter, int portOutput, int portServer, int portReceptor) {
        this.panel = panel;
        this.input = input;
        this.scroll = scroll;
        this.emitter = emitter;
        this.portOutput = portOutput;
        this.portServer = portServer;
        this.portReceptor = portReceptor;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == 10) {

            if (input.getForeground() == Color.LIGHT_GRAY) {
                return;
            }
            if (input.getForeground() == Color.BLACK) {
                Message newMessage = new Message(this.emitter, input.getText(), true);
                panel.addNewMessage(newMessage);
                // Send to server
                try {
                    Socket socket = new Socket("192.168.1.103", this.portServer);
                    ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());

                    MessageDataTransfer dataTransfer = new MessageDataTransfer(
                            this.portOutput,
                            this.portReceptor,
                            newMessage
                    );

                    output.writeObject(dataTransfer);
                    output.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                panel.revalidate();
                input.reset();
                panel.repaint();
                scroll.validate();
                scroll.repaint();
                JScrollBar vertical = scroll.getVerticalScrollBar();
                vertical.setValue( vertical.getMaximum() );

                panel.requestFocusInWindow();
            }
        }
    }
}
