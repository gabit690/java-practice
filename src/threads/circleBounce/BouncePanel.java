package threads.circleBounce;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class BouncePanel extends JPanel implements ActionListener {

    private Dimension size;

    private List<Ball> balls = new ArrayList<>();

    private boolean concurrent;

    public BouncePanel(int width, int height, boolean concurrent) {

        this.size = new Dimension(width, height);

        this.concurrent = concurrent;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(this.balls.size() < 10) {
            this.startAnimation();
        } else {
            System.out.println("LIST FULL");
        }


    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
//        super.paintComponent(g);

        Graphics2D g2=(Graphics2D)g;

        for(Ball b: balls){
            g2.setColor(b.isActive() ? Color.GREEN : Color.RED);
            g2.fill(b.getShape());
        }
    }

    public void add(Ball ball) {
        this.balls.add(ball);
    }

    private void startAnimation() {

        Random random = new Random();

        int sizeBall = 10;

        Point maxPosition = new Point(
                (int) this.size.getWidth() - sizeBall,
                (int) this.size.getHeight() - sizeBall
        );

        Point randomPosition = new Point(
                random.nextInt((int) maxPosition.getX() - 1) + 1,
                random.nextInt((int) maxPosition.getY() - 1) + 1
        );

        Ball ball = new Ball(
                sizeBall,
                new Point((int) randomPosition.getX(), (int) randomPosition.getY()),
                new Point((int) maxPosition.getX(), (int) maxPosition.getY()),
                3);

        this.add(ball);

        if (this.concurrent) {

            Runnable r = new AnimationConcurrent(this, ball);

            Thread t = new Thread(r);

            t.start();

        } else {

            while (ball.isActive()) {
                ball.move();
                this.paint(this.getGraphics());
                try {
                    Thread.sleep(10);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }

        }
    }
}

class AnimationConcurrent implements Runnable {

    private BouncePanel panel;

    private Ball ball;

    public AnimationConcurrent(BouncePanel panel, Ball ball) {

        this.panel = panel;

        this.ball = ball;
    }

    @Override
    public void run() {

        while (ball.isActive()) {
            ball.move();
            this.panel.paint(this.panel.getGraphics());
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        }

    }
}
