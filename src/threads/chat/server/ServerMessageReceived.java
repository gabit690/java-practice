package threads.chat.server;

import threads.chat.Message;
import threads.chat.MessageDataTransfer;

import javax.swing.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalTime;

public class ServerMessageReceived implements Runnable {

    private int port;
    private ServerDisplay display;

    private JScrollPane scroll;

    public ServerMessageReceived(ServerDisplay display, JScrollPane scroll, int port) {
        this.display = display;
        this.scroll = scroll;
        this.port = port;
    }

    @Override
    public void run() {
        try {
            ServerSocket server = new ServerSocket(this.port);
            while (true) {
                Socket socketInput = server.accept();
                ObjectInputStream input = new ObjectInputStream(socketInput.getInputStream());
                MessageDataTransfer data = (MessageDataTransfer) input.readObject();
                JLabel line = new JLabel(LocalTime.now().toString().substring(0, 8) + " [" + data.getContent().getAuthor().toUpperCase() + "] sent 1 message.");
                display.addNewMessage(line);
                display.revalidate();
                display.repaint();
                scroll.validate();
                scroll.repaint();
                JScrollBar vertical = scroll.getVerticalScrollBar();
                vertical.setValue( vertical.getMaximum() );

                Socket socketOutput = new Socket("192.168.1.103", data.getPortDestiny());
                ObjectOutputStream output = new ObjectOutputStream(socketOutput.getOutputStream());
                Message message = new Message("Receptor", data.getContent().getContent(), false);
                output.writeObject(message);
                output.close();

                input.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
