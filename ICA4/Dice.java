import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Dice extends JFrame {
    private Random random;
    private JLabel leftDie, rightDie;
    private JButton rollDiceButton;
    private ImageIcon dice[];

    private class RollDiceListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            rollDie(leftDie);
            rollDie(rightDie);
        }
    }

    private void rollDie(JLabel die) {
        die.setIcon(dice[random.nextInt(6)]);
    }

    private void initialize() {
        random = new Random();
        setSize(220, 175);
        setTitle("Dice Roll Simulator");

        dice = new ImageIcon[] { new ImageIcon("Die1.png"), new ImageIcon("Die2.png"), new ImageIcon("Die3.png"),
                new ImageIcon("Die4.png"), new ImageIcon("Die5.png"), new ImageIcon("Die6.png") };

        JPanel diePanel = new JPanel();
        diePanel.setLayout(new GridLayout(1, 2));
        leftDie = new JLabel(dice[0]);
        rightDie = new JLabel(dice[0]);
        diePanel.add(leftDie);
        diePanel.add(rightDie);

        rollDiceButton = new JButton("Roll the Dice");
        rollDiceButton.addActionListener(new RollDiceListener());

        this.setLayout(new BorderLayout());
        this.add(diePanel, BorderLayout.NORTH);
        this.add(rollDiceButton, BorderLayout.SOUTH);

    }

    public Dice() {
        initialize();

        setVisible(true);
    }

    public static void main(String[] args) {
        new Dice();
    }
}