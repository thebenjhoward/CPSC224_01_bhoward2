import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PlayerPanel extends JPanel {
    private JLabel player;
    private JTextField playerName;
    private JLabel name;
    private JLabel wins;
    private JLabel losses;
    private JLabel numWins;
    private JLabel numLosses;
    private int winsValue = 0;
    private int lossesValue = 0;

    public String getName() {
        return playerName.getText();
    }

    public void addWin()
    {
        winsValue++;
        numWins.setText(Integer.toString(winsValue));
    }

    public void addLoss()
    {
        lossesValue++;
        numLosses.setText(Integer.toString(lossesValue));
    }

    public PlayerPanel(int playerNum) {
        setLayout(new GridLayout(3, 2));
        setSize(250, 100);

        name = new JLabel("Name: ");
        wins = new JLabel("Wins: ");
        losses = new JLabel("Losses: ");
        numWins = new JLabel("0");
        numLosses = new JLabel("0");
        playerName = new JTextField();

        if (playerNum == 1) {
            setBorder(BorderFactory.createTitledBorder("Player 1 (X):"));
        } else {
            setBorder(BorderFactory.createTitledBorder("Player 2 (O):"));
        }

        add(name);
        add(playerName);
        add(wins);
        add(numWins);
        add(losses);
        add(numLosses);

        // add(playerName);

    }

    void startGame() {
        playerName.setEnabled(false);
    }

}
