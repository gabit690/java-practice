package threads.chat.client;

import threads.chat.Message;

import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientReceivedMessage extends Thread {

    private ChatDisplay panel;

    private JScrollPane scroll;

    private int portReceiver;

    public ClientReceivedMessage(ChatDisplay panel, JScrollPane scroll, int portReceiver) {
        this.panel = panel;
        this.scroll = scroll;
        this.portReceiver = portReceiver;
    }

    @Override
    public void run() {

        try {
            ServerSocket server = new ServerSocket(this.portReceiver);
            while (true) {
                Socket socket = server.accept();
                ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
                Message data = (Message) input.readObject();
                this.panel.addNewMessage(data);
                this.panel.add(data);
                panel.revalidate();
                panel.repaint();
                scroll.validate();
                scroll.repaint();
                JScrollBar vertical = scroll.getVerticalScrollBar();
                vertical.setValue( vertical.getMaximum() );
                input.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
