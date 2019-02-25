import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GameGUI extends JFrame
{
    private PlayerPanel player1, player2;
    private StatusPanel status;
    private BoardPanel board;
    private JButton newGameButton;
    private JButton resetButton;
    private JButton exitButton;
    private JPanel players;
    private JPanel buttonPanel;
    private final int WINDOW_WIDTH = 400;
    private final int WINDOW_HEIGHT = 100;

    public GameGUI()
    {
      // Display a title
      setTitle("Tic Tac Toe");

      // Specify an action for the close button.
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      // Create a BorderLayout manager.
      setLayout(new BorderLayout());
      buildPlayerPanel();
      buildButtonPanel();
      add(players, BorderLayout.NORTH);
      add(buttonPanel, BorderLayout.SOUTH);

      // Create custom panels

      //status = new StatusPanel();
      //board = new BoardPanel();

      //Create the button panel
      //buildButtonPanel();


    //add(board);
      //add(buttonPanel);
      //add(status);

      pack();
      setVisible(true);
      }


      private void buildPlayerPanel(){
          players = new JPanel();
          players.setSize(500, 500);
          player1 = new PlayerPanel(1);
          player2 = new PlayerPanel(2);
          players.add(player1);
          players.add(player2);
      }

    // buildButton panel method that builds the button panel
      private void buildButtonPanel()
      {
        // Create a panel for the buttons.
        buttonPanel = new JPanel();

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
        buttonPanel.add(exitButton);
      }


      private class NewGameButtonListener implements ActionListener
      {
        public void actionPerformed(ActionEvent e)
        {
            System.out.println("new game button");
            player1.startGame();
            player2.startGame();
            /*
            if game is in progress, call reset functions and then enable functions,
            else just call enable functions
            */

        }
      }


      private class ResetButtonListener implements ActionListener
      {
        public void actionPerformed(ActionEvent e)
        {
            System.out.println("reset button!");
            /*
            calls reset functions
            */
        }
      }

      private class ExitButtonListener implements ActionListener
      {
        public void actionPerformed(ActionEvent e)
        {
          System.exit(0);
        }
      }

      public static void main(String[] args)
      {
        new GameGUI();
      }

}
