package threads;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {

    public static void main(String[] args)  {

        JFrame app = new JFrame("Client");

        Layer cape = null;
        try {
            cape = new Layer();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        app.add(cape);
        app.pack();

        app.setLocationRelativeTo(null);
        app.setResizable(false);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);
    }
}

class Layer extends JPanel {

    private AppStatus status;

    private JButton play;

    private JButton pause;

    private JButton stop;

    public Layer() throws IOException {
        this.status = AppStatus.STOPPED;
        this.play = new JButton("PLAY");
        this.pause = new JButton("PAUSE");
        this.stop = new JButton("STOP");
        this.onInit();
    }

    public void onInit() {

        this.play.setSize(100, 50);
        this.pause.setSize(100, 50);
        this.stop.setSize(100, 50);
        this.play.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (status == AppStatus.PLAYED) {
                    System.out.println("Don't replay");
                    return;
                }

                if (status == AppStatus.PAUSED) {
                    System.out.println("continue");
                } else {
                    System.out.println("Start");
                }

                try {
                    Socket bridge = new Socket("192.168.1.103", 8081);
                    DataOutputStream output = new DataOutputStream(bridge.getOutputStream());
                    output.writeUTF(AppStatus.PLAYED.toString());
                    output.close();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                status = AppStatus.PLAYED;

            }
        });

        this.pause.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (status != AppStatus.PLAYED) {
                    System.out.println("It isn't PLAYED");
                    return;
                }

                try {
                    Socket bridge = new Socket("192.168.1.103", 8081);
                    DataOutputStream output = new DataOutputStream(bridge.getOutputStream());
                    output.writeUTF(AppStatus.PAUSED.toString());
                    output.close();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                status = AppStatus.PAUSED;
            }
        });

        this.stop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (status == AppStatus.STOPPED) {
                    System.out.println("Don't reSTOP");
                    return;
                }

                try {
                    Socket bridge = new Socket("192.168.1.103", 8081);
                    DataOutputStream output = new DataOutputStream(bridge.getOutputStream());
                    output.writeUTF(AppStatus.STOPPED.toString());
                    output.close();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

                status = AppStatus.STOPPED;
            }
        });

        add(this.play);
        add(this.pause);
        add(this.stop);
    }
}

enum AppStatus {
    PLAYED, PAUSED, STOPPED
}