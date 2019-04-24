package StoryPlayer;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ChoicesPanel extends JPanel {
  private JButton[] options = new JButton[4];

    public ChoicesPanel() {
      setSize(750, 300);
      setLayout(new GridLayout(4, 1));
      initializeButtons();
    }



/*---------------------------------------------------------
//////////////////// PRIVATE CLASSES /////////////////////
-----------------------------------------------------------*/

private class ButtonListener implements ActionListener
{
  public void actionPerformed(ActionEvent e)
  {
    for(int i = 0; i < 4; i++){
      if(e.getSource() == options[i]){
        System.out.println("Button " + (i+1) + " was pressed.");
      }
    }
  }
}


/*---------------------------------------------------------
//////////////////// HELPER FUNCTIONS /////////////////////
-----------------------------------------------------------*/

    // ----------INITIALIZE BUTTONS------------
    // disable button by passing in option number
    // usage: ChoicesPanel.initializeButtons();
    public void initializeButtons(){
      for(int i = 0; i < 4; i++){
        options[i] = new JButton("Option" + (i+1));
      }
/*
      options[0].setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
      options[1].setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
      options[2].setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
      options[3].setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
*/
      for(int i = 0; i < 4; i++){
        //options[i].setEnabled(true);
        add(options[i]);
      }
    }

    // ----------DISABLE BUTTON------------
    // disable button by passing in option number
    // usage: ChoicesPanel.disableButton(1);
    public void disableButton(int option){
      options[option+1].setEnabled(false);
    }

    // ----------ENABLE BUTTON------------
    // disable button by passing in option number
    // usage: ChoicesPanel.disableButton(1);
    public void enableButton(int option){
      options[option-1].setEnabled(true);
    }

    // ----------SET BUTTON------------
    // sets button text given option number and text
    // usage: ChoicesPanel.setButton(1, "turn left");
    public void setButton(int option, String newText){
      options[option-1].setText(newText);
    }
}
