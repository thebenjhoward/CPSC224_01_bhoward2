package StoryPlayer;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GameGUI extends JFrame{
  private ChoicesPanel choices;

  public GameGUI() {
      // Display a title
      setTitle("Bandersnatch");
      setSize(500, 500);

      choices = new ChoicesPanel();

      // Create a BorderLayout manager.
      setLayout(new BorderLayout());
      add(choices);

      setVisible(true);
    }

    public static void main(String[] args){
      new GameGUI();
    }
}
