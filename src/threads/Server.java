package threads;

import javax.swing.*;
import java.awt.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {

        JFrame app = new JFrame("Server");
        LayerServer mainPanel = new LayerServer(300, 100);
        app.add(mainPanel);
        app.pack();


        Thread t = new Thread(mainPanel);
        t.start();

        app.setLocationRelativeTo(null);
        app.setResizable(false);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);
    }
}

class LayerServer extends JPanel implements Runnable {

    private int width;

    private int height;

    private JLabel status;

    public LayerServer(int width, int height) {
        this.width = width;
        this.height = height;
        this.status = new JLabel("OFF");
        this.onInit();
    }

    private void onInit() {
        this.status.setFont(new Font("Arial", Font.BOLD, 50));
        add(this.status);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(this.width, this.height);
    }

    @Override
    public void run() {
        try {
            ServerSocket server = new ServerSocket(8081);
            while (true) {

                Socket socket = server.accept();
                DataInputStream input = new DataInputStream(socket.getInputStream());
                String appStatus = input.readUTF();
                status.setText(appStatus);
                input.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}