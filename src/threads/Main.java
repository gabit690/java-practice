package threads;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        JFrame app = new JFrame("Actions");

        Layer cape = new Layer();
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

    private Action action;

    private JButton play;

    private JButton pause;

    private JButton stop;

    public Layer() {
        this.status = AppStatus.STOPPED;
        this.action = new Action();
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
                    action = new Action();
                    System.out.println("continue");
                } else {
                    System.out.println("Start");
                }

                action.start();
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

                status = AppStatus.PAUSED;
                action.interrupt();
            }
        });

        this.stop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (status == AppStatus.STOPPED) {
                    System.out.println("Don't reSTOP");
                    return;
                }

                if (status == AppStatus.PLAYED) {
                    action.interrupt();
                }

                action = new Action();
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

class Action extends Thread {

    @Override
    public void run() {

        while (!this.isInterrupted()) {
            System.out.println((LocalTime.now()));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}