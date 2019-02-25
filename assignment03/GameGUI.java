import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GameGUI extends JFrame {
    private PlayerPanel player1, player2;
    private StatusPanel status;
    private BoardPanel board;
    private JButton newGameButton;
    private JButton resetButton;
    private JButton exitButton;
    private JPanel players;
    private JPanel buttonPanel;
    private final int WINDOW_WIDTH = 500;
    private final int WINDOW_HEIGHT = 500;

    public GameGUI() {
        // Display a title
        setTitle("Tic Tac Toe");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        // Specify an action for the close button.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a BorderLayout manager.
        setLayout(new BorderLayout());
        buildPlayerPanel();
        buildButtonPanel();
        add(players, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);

        // Create custom panels

        // status = new StatusPanel();
        board = new BoardPanel(this);
        add(board, BorderLayout.CENTER);

        // Create the button panel
        // buildButtonPanel();

        // add(board);
        // add(buttonPanel);
        // add(status);

        // pack();
        setVisible(true);
    }

    private void buildPlayerPanel() {
        players = new JPanel();
        // players.setSize(500, 500);
        players.setLayout(new GridLayout(1, 2));
        player1 = new PlayerPanel(1);
        player2 = new PlayerPanel(2);
        players.add(player1);
        players.add(player2);
    }

    // buildButton panel method that builds the button panel
    private void buildButtonPanel() {
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

    public void NextTurn() {
        
        // Add change to status panel here

        // Check for winner 
        BoardPanel.WinType winStatus = board.getWinStatus();
        switch (winStatus) {
        case X_WIN:
            JOptionPane.showMessageDialog(this, player1.getName() + " Wins!");
            player1.addWin();
            player2.addLoss();
            board.disableButtons();
            // Add change to status panel here
            break;
        case O_WIN:
            JOptionPane.showMessageDialog(this, player1.getName() + " Wins!");
            player1.addWin();
            player2.addLoss();
            board.disableButtons();
            break;
        default:
            break;
        }
    }

    private class NewGameButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("new game button");
            player1.startGame();
            player2.startGame();

            board.reset();
            board.enableButtons();

            // Add change to status panel here

        }
    }

    private class ResetButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("reset button!");
            player1.reset();
            player2.reset();
            board.reset();
        }
    }

    private class ExitButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new GameGUI();
    }

}
