package threads.circleBounce;

import javax.swing.*;
import java.awt.*;

public class MainLayer extends JPanel {

    private Dimension size;

    private Point innerPanelPadding;

    private BouncePanel defaultBounce;

    private JButton defaultBall;

    private BouncePanel concurrentBounce;

    private JButton concurrentBall;

    public MainLayer(int width, int height) {
        this.size = new Dimension(width, height);
        this.innerPanelPadding = new Point(25, height / 6);

        this.defaultBounce = new BouncePanel(
                (width - (4 * (int) this.innerPanelPadding.getX())) / 2,
                4 * (int) this.innerPanelPadding.getY(),
                false
        );
        this.defaultBall = new JButton("Add");

        this.concurrentBounce = new BouncePanel(
                (width - (4 * (int) this.innerPanelPadding.getX())) / 2,
                4 * (int) this.innerPanelPadding.getY(),
                true
        );
        this.concurrentBall = new JButton("Add");
        this.setLayout(null);
    }

    @Override
    public void doLayout() {
        super.doLayout();

        // Default title
        JLabel defaultPanelTitle = new JLabel("Default");
        defaultPanelTitle.setBounds(105, 25, 90, 20);
        defaultPanelTitle.setFont(new Font("Arial", Font.BOLD, 24));
        this.add(defaultPanelTitle);

        // Default Panel
        this.defaultBounce.setSize(
                ((int) (this.size.getWidth() - (4 * this.innerPanelPadding.getX()))) / 2,
                4 * (int) this.innerPanelPadding.getY()
        );
        this.defaultBounce.setLocation((int) this.innerPanelPadding.getX(), (int) this.innerPanelPadding.getY());
        this.defaultBounce.setBackground(Color.BLACK);
        this.add(this.defaultBounce);

        // Default button
        this.defaultBall.setBounds(100, 350, 100, 30);
        this.defaultBall.addActionListener(this.defaultBounce);
        this.add(this.defaultBall);


        // Concurrent title
        JLabel concurrentPanelTitle = new JLabel("Concurrent");
        concurrentPanelTitle.setBounds(390, 25, 130, 20);
        concurrentPanelTitle.setFont(new Font("Arial", Font.BOLD, 24));
        this.add(concurrentPanelTitle);

        // Concurrent Panel
        this.concurrentBounce.setSize(
                ((int) (this.size.getWidth() - (4 * this.innerPanelPadding.getX()))) / 2,
                4 * (int) this.innerPanelPadding.getY()
        );
        this.concurrentBounce.setLocation(
                (this.size.width / 2) + (int) this.innerPanelPadding.getX(),
                (int) this.innerPanelPadding.getY());
        this.concurrentBounce.setBackground(Color.BLACK);
        this.add(this.concurrentBounce);

        // Concurrent button
        this.concurrentBall.setBounds(
                400,
                350,
                100,
                30);
        this.concurrentBall.addActionListener(this.concurrentBounce);
        this.add(this.concurrentBall);

    }

    @Override
    public Dimension getPreferredSize() {
        return this.size;
    }
}
