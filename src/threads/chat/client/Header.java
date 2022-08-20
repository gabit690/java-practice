package threads.chat.client;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

class Header extends JLabel {

    public Header(String text, int horizontalAlignment) {
        super(text, horizontalAlignment);
        this.setBorder(new EmptyBorder(10, 0, 0, 0));
        this.setFont(new Font("Arial", Font.BOLD, 20));
    }
}