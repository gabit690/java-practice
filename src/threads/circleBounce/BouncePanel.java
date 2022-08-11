package threads.circleBounce;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.util.Random;

class BouncePanel extends JPanel implements ActionListener {

    private int width;

    private int height;

    private Ellipse2D ball;

    private int ballSize;

    public BouncePanel(int width, int height) {
        this.width = width;
        this.height = height;

        Random random = new Random();

        int randomX = random.nextInt(this.width + 1);

        int randomY = random.nextInt(this.height + 1);

        this.ballSize = 10;

        this.ball = new Ellipse2D.Double(randomX - ballSize, randomY - ballSize, ballSize, ballSize);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        setBackground(Color.GREEN);

        this.ball = new Ellipse2D.Double(this.ball.getX() - this.ballSize, this.ball.getY() - this.ballSize, this.ballSize, this.ballSize);

        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.WHITE);
        g2.fill(ball);
        g2.draw(ball);
    }
}
