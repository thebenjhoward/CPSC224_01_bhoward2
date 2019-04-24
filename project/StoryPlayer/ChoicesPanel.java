package StoryPlayer;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ChoicesPanel extends JPanel {
  private JButton[] options = new JButton[4];

    public ChoicesPanel() {

      setSize(750, 500);
      setLayout(new GridLayout(1, 4));
      initializeButtons();

    }

    // disable button by passing in option number
    // usage: ChoicesPanel.initializeButtons();
    public void initializeButtons(){
      for(int i = 0; i < 4; i++){
        options[i] = new JButton("Option" + (i+1));
      }

      options[0].setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
      options[1].setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
      options[2].setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
      options[3].setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));

      for(int i = 0; i < 4; i++){
        add(options[i]);
      }
    }

    // disable button by passing in option number
    // usage: ChoicesPanel.disableButton(1);
    public void disableButton(int option){
      options[option+1].setEnabled(false);
    }

    // disable button by passing in option number
    // usage: ChoicesPanel.disableButton(1);
    public void enableButton(int option){
      options[option+1].setEnabled(true);
    }

    // sets button text given option number and text
    // usage: ChoicesPanel.setButton(1, "turn left");
    public void setButton(int option, String newText){
      options[option+1].setText(newText);
    }

}