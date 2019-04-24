package StoryPlayer;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ChoicesPanel extends JPanel {
    private JButton[] options = new JButton[4];

    public ChoicesPanel() {
        setLayout(new GridLayout(4, 1));
        initializeButtons();
        setPreferredSize(new Dimension(750, 300));

    }

    /*---------------------------------------------------------
    //////////////////// HELPER FUNCTIONS /////////////////////
    -----------------------------------------------------------*/

    // ----------INITIALIZE BUTTONS------------
    // disable button by passing in option number
    // usage: ChoicesPanel.initializeButtons();
    public void initializeButtons() {
        for (int i = 0; i < 4; i++) {
            options[i] = new JButton("Option" + (i + 1));
        }
        /*
         * options[0].setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
         * options[1].setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
         * options[2].setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
         * options[3].setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
         */
        for (int i = 0; i < 4; i++) {
            // options[i].setEnabled(true);
            add(options[i]);
        }
    }

    public void setButtonEnabled(int option, boolean b) {
        options[option].setEnabled(b);
    }

    // ----------SET BUTTON------------
    // sets button text given option number and text
    // usage: ChoicesPanel.setButton(1, "turn left");
    public void setButtonText(int option, String newText) {
        options[option].setText(newText);
    }

    public void setButtonListener(int option, ActionListener l) {
        options[option].addActionListener(l);
    }
}
