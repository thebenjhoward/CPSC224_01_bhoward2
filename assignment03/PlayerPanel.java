import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PlayerPanel extends JPanel
{
    private JLabel player;
    private JTextField playerName;
    private JLabel name;
    private JLabel wins;
    private JLabel losses;
    private JLabel numWins;
    private JLabel numLosses;
    int numberWins;
    int numberLosses;


    public PlayerPanel(int playerNum)
    {
        setLayout(new GridLayout(3, 2));
        setSize(250, 100);

        name = new JLabel("Name: ");
        wins = new JLabel("Wins: ");
        losses = new JLabel("Losses: ");
        numWins = new JLabel("0");
        numLosses = new JLabel("0");
        playerName = new JTextField();

        if(playerNum == 1){
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

        //add(playerName);

    }

    void startGame(){
      playerName.setEnabled(false);
    }


}
