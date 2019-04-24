import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GameGUI extends JFrame {
    private JPanel buttonPanel;
    private JPanel imagePanel;
    private JButton[] options = new JButton[4];

    /*

    private PlayerPanel player1, player2;
    private StatusPanel status;
    private BoardPanel board;
    private JButton newGameButton;
    private JButton resetButton;
    private JButton exitButton;
    private JPanel players;
    private JPanel buttonPanel;*/
    private final int WINDOW_WIDTH = 500;
    private final int WINDOW_HEIGHT = 500;


    public GameGUI() {
        // Display a title
        setTitle("Bandersnatch");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        // Specify an action for the close button.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a BorderLayout manager.
        setLayout(new BorderLayout());

        buildButtonPanel();
        add(buttonPanel);

        setVisible(true);
    }

    // buildButton panel method that builds the button panel
    private void buildButtonPanel() {
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 1));
        for(int i = 0; i < 4; i++){
          options[i] = new JButton("Option " + (i + 1));
          buttonPanel.add(options[i]);
        }
      }

      private class buttonListener implements ActionListener {
          public void actionPerformed(ActionEvent e) {
          if
/*
        // Create the buttons.
        newGameButton = new JButton("New Game");
        resetButton = new JButton("Reset");
        exitButton = new JButton("Exit");

        // Register the action listeners.
        newGameButton.addActionListener(new NewGameButtonListener());
        resetButton.addActionListener(new ResetButtonListener());
        exitButton.addActionListener(new ExitButtonListener());

        // Add the buttons to the button panel.
        buttonPanel.add(newGameButton);
        buttonPanel.add(resetButton);
        buttonPanel.add(exitButton);*/

}
