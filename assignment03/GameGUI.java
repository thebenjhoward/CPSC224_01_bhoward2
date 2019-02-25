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

    private boolean gameInProgress = false;

    public GameGUI() {
        // Display a title
        setTitle("Tic Tac Toe");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        // Specify an action for the close button.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a BorderLayout manager.
        setLayout(new BorderLayout());
        buildPlayerPanel();

        // Create custom panels
        status = new StatusPanel();
        board = new BoardPanel(this);

        // Create the button panel
        buildButtonPanel();

        JPanel buttonStatusPanel = new JPanel();
        buttonStatusPanel.setLayout(new BorderLayout());
        buttonStatusPanel.add(buttonPanel, BorderLayout.NORTH);
        buttonStatusPanel.add(status, BorderLayout.SOUTH);

        add(players, BorderLayout.NORTH);
        add(board, BorderLayout.CENTER);
        add(buttonStatusPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void buildPlayerPanel() {
        players = new JPanel();
        // players.setLayout(new GridLayout(1, 2));
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

        if (board.getIsXTurn())
            status.setText(player1.getName() + "'s turn");
        else
            status.setText(player2.getName() + "'s turn");

        // Check for winner
        BoardPanel.WinType winStatus = board.getWinStatus();
        switch (winStatus) {
        case X_WIN:
            JOptionPane.showMessageDialog(this, player1.getName() + " Wins!");
            player1.addWin();
            player2.addLoss();
            board.disableButtons();
            gameInProgress = false;
            status.setText("Select new game to start again!");
            break;
        case O_WIN:
            JOptionPane.showMessageDialog(this, player2.getName() + " Wins!");
            player2.addWin();
            player1.addLoss();
            board.disableButtons();
            gameInProgress = false;
            status.setText("Select new game to start again!");
            break;
        case TIE:
            JOptionPane.showMessageDialog(this, "It's a Tie!");
            board.disableButtons();
            gameInProgress = false;
            status.setText("Select new game to start again!");
            break;
        default:
            break;
        }
    }

    private class NewGameButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            if (gameInProgress) {
                if (JOptionPane.showConfirmDialog(null,
                        "This will start a new game, reseting your current game. Are you sure?", "Are you sure?",
                        JOptionPane.YES_NO_OPTION) == 1) {
                    return;
                }
            }

            player1.startGame();
            player2.startGame();

            board.reset();
            board.enableButtons();
            gameInProgress = true;

            status.setText(player1.getName() + "'s turn");

        }
    }

    private class ResetButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (JOptionPane.showConfirmDialog(null,
                    "This will end the game and set the win/loss stats to 0. Are you sure?", "Are you sure?",
                    JOptionPane.YES_NO_OPTION) == 1) {
                return;
            }

            player1.reset();
            player2.reset();
            board.reset();

            gameInProgress = false;
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
