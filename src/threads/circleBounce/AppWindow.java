package threads.circleBounce;

import javax.swing.*;
import java.awt.*;

public class AppWindow extends JFrame {
    private String title;
    private String icon;
    private int width;
    private int height;

    private MainLayer mainLayer;

    public AppWindow(String title, String icon, int width, int height) {
        this.title = title;
        this.icon = icon;
        this.width = width;
        this.height = height;
        this.mainLayer = new MainLayer(this.width, this.height);
        this.configFrame();
    }

    public void showWindow() {
        this.setVisible(true);
    }

    private void configFrame() {
        setTitle(this.title);
        setIconImage(Toolkit.getDefaultToolkit().getImage(this.icon));
        add(this.mainLayer);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
