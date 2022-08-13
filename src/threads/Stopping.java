package threads;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Stopping {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Stop");

        JPanel cape = new JPanel(null) {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(600, 400);
            }
        };

        JPanel background = new JPanel();
        background.setBackground(Color.BLACK);
        background.setBounds(50, 50, 500, 200);

        JButton play = new JButton("Play");
        play.setBounds(100, 300, 100, 50);

        Runnable r = new Blink(background);
        final Thread[] t = {new Thread(r)};

        play.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (t[0].isInterrupted()) {
                    System.out.println("REStart");
                    t[0] = new Thread(r);
                }
                t[0].start();

            }
        });


        JButton stop = new JButton("Stop");
        stop.setBounds(400, 300, 100, 50);
        stop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t[0].interrupt();
            }
        });

        cape.add(play);
        cape.add(stop);


        cape.add(background);

        frame.add(cape);
        frame.pack();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
    }
}

class Blink implements Runnable {

    private JPanel panel;

    public Blink(JPanel component) {
        this.panel = component;
    }

    @Override
    public void run() {
        Color current = Color.BLACK;
        while (!Thread.interrupted()) {
            if (current == Color.BLACK) {
                panel.setBackground(Color.WHITE);
                current = Color.WHITE;
            } else {
                panel.setBackground(Color.BLACK);
                current = Color.BLACK;
            }
            panel.paint(panel.getGraphics());
        }

    }
}