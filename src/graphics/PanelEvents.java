package graphics;

import javax.imageio.ImageIO;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.Timer;

import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.io.File;
import java.io.IOException;

public class PanelEvents {

    public static void main(String[] args) {

        FrameInteractive myFrame = new FrameInteractive();

        myFrame.showWindow();
    }
}

class FrameInteractive extends JFrame {

    public FrameInteractive() {

        // Frame config
        Toolkit deviceScreen = Toolkit.getDefaultToolkit();

        Dimension screenSize = deviceScreen.getScreenSize();

        setTitle("Quiz");

        setSize(700, 400);

        setLocation((screenSize.width - 700) / 2, (screenSize.height - 400) / 2);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setResizable(false);

        Image icon = Toolkit.getDefaultToolkit().getImage("src/graphics/img/icon.png");

        setIconImage(icon);

        MainCape myCape = new MainCape();

        add(myCape);

        this.setVisible(true);
    }

    public void showWindow() {

        this.setVisible(true);
    }
}

class MainCape extends JPanel {

    private Image _img;

    private  JLabel _imageLabel = new JLabel(new ImageIcon("src/graphics/img/sadCat.png"));

    private JLabel _textLabel = new JLabel("Are cats astonishing?");

    private JButton _affirmativeButton = new JButton("YES");

    private JButton _negativeButton = new JButton("NO");



    public MainCape() {

        this.setLayout(null);

        this._imageLabel.setBounds(265, 20, 170, 170);

        this._textLabel.setBounds(180, 210, 340, 35);

        this._textLabel.setFont(new Font("Arial", Font.BOLD, 32));

        this._affirmativeButton.setBounds(150, 275, 100 , 50);

        this._negativeButton.setBounds(450, 275, 100 , 50);

        try {
            this._img = ImageIO.read(new File("src/graphics/img/sadCat.png"));
        } catch (IOException e) {

            System.out.println("Image no found");
        }

        Background backgroundAffirmative = new Background(Color.GREEN);

        this._affirmativeButton.addActionListener(backgroundAffirmative);

        this._negativeButton.addActionListener(backgroundAffirmative);

        this._negativeButton.addMouseListener(new MouseOnButton());

        this.add(this._imageLabel);

        this.add(this._textLabel);

        this.add(this._affirmativeButton);

        this.add(this._negativeButton);
    }

    private class Background implements ActionListener {

        private Timer _timer = new Timer(500, null);
        private Color _color;

        public Background(Color color) {

            this._color = color;
        }

        public void actionPerformed(ActionEvent e) {

            _timer.start();

            _timer.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(getBackground() == Color.GREEN) {
                        setBackground(new Color(238, 238, 238));
                    } else {
                        setBackground(Color.GREEN);
                    }
                }
            });

            _imageLabel.setIcon(new ImageIcon("src/graphics/img/happyCat.png"));

            _textLabel.setBounds(195, 210, 310, 35);

            _textLabel.setText("You're right, human!");

            setBackground(this._color);
        }
    }

    private class MouseOnButton extends MouseAdapter {

        public void mouseEntered(MouseEvent e) {

            JButton element = (JButton) e.getSource();

            element.setText("YES");

        }

        public void mouseExited(MouseEvent e) {

            JButton element = (JButton) e.getSource();

            element.setText("NO");
        }
    }
}