package threads.chat.client;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class InputField extends JTextField {

    public InputField(String text, int columns) {
        super(text, columns);
        this.onInit();
    }

    private void onInit() {
        this.setForeground(Color.LIGHT_GRAY);
        this.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (getForeground() == Color.LIGHT_GRAY) {
                    setForeground(Color.BLACK);
                    setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (getText().length() == 0) {
                    reset();
                }
            }
        });
    }

    public void reset() {
        this.setForeground(Color.LIGHT_GRAY);
        this.setText("Message (max 24 chars)");
    }
}

class JTextFieldLimit extends PlainDocument {
    private int limit;
    JTextFieldLimit(int limit) {
        super();
        this.limit = limit;
    }
    JTextFieldLimit(int limit, boolean upper) {
        super();
        this.limit = limit;
    }
    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
        if (str == null)
            return;
        if ((getLength() + str.length()) <= limit) {
            super.insertString(offset, str, attr);
        }
    }
}