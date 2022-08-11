package threads.circleBounce;

import javax.swing.*;
import java.awt.*;

public class MainLayer extends JPanel {

    private int width;

    private int height;

    private int paddingX;

    private int paddingY;

    private BouncePanel defaultBounce;

    private JButton defaultBall;

    private JPanel concurrentBounce;

    private JButton concurrentBall;

    public MainLayer(int width, int height) {
        this.width = width;
        this.height = height;
        this.paddingX = 25;
        this.paddingY = height / 6;
        this.defaultBounce = new BouncePanel(width - (2 * this.paddingX), 4 * this.paddingY);
        this.defaultBall = new JButton(String.valueOf(height));
        this.concurrentBounce = new JPanel(null);
        this.concurrentBall = new JButton("Concurrent ball");
        this.setLayout(null);
    }

    @Override
    public void doLayout() {
        super.doLayout();

        // Default Panel
        this.defaultBounce.setSize(this.width - (2 * this.paddingX), 4 * this.paddingY);
        this.defaultBounce.setLocation(this.paddingX, this.paddingY);
        this.defaultBounce.setBackground(Color.BLACK);
        this.add(this.defaultBounce);

        // Default button
        this.defaultBall.setBounds(250, 350, 100, 30);
        this.defaultBall.addActionListener(this.defaultBounce);
        this.add(this.defaultBall);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(this.width, this.height);
    }
}
