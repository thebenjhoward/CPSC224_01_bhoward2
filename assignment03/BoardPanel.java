import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
import java.awt.GridLayout;

public class BoardPanel extends JPanel {
    // Data Members
    private JButton buttonTL, buttonTM, buttonTR, buttonML, buttonMM, buttonMR, buttonBL, buttonBM, buttonBR;

    private String[][] buttonValues = new String[][] { new String[] { "", "", "" }, new String[] { "", "", "" },
            new String[] { "", "", "" } };

    private boolean isXTurn = true;

    private GameGUI gameObject;

    // Classes/Object Types
    public enum WinType {
        NONE, X_WIN, O_WIN, TIE
    }

    private class ticTacToeListener implements ActionListener {
        private int row, column;

        public ticTacToeListener(int row, int column) {
            this.row = row;
            this.column = column;
        }

        public void actionPerformed(ActionEvent e) {
            if (buttonValues[row][column].equals("")){
                updateButton(row, column);
            }
        }
    }

    // Methods
    public void updateButtons() {
        buttonTL.setText(buttonValues[0][0]);
        buttonTM.setText(buttonValues[0][1]);
        buttonTR.setText(buttonValues[0][2]);
        buttonML.setText(buttonValues[1][0]);
        buttonMM.setText(buttonValues[1][1]);
        buttonMR.setText(buttonValues[1][2]);
        buttonBL.setText(buttonValues[2][0]);
        buttonBM.setText(buttonValues[2][1]);
        buttonBR.setText(buttonValues[2][2]);
    }

    public Boolean getIsXTurn()
    {
        return isXTurn;
    }

    public void updateButton(int row, int column) {
        if (isXTurn) {
            buttonValues[row][column] = "X";
        } else {
            buttonValues[row][column] = "O";
        }

        isXTurn = !isXTurn;

        switch (row) {
        case 0:
            if (column == 0) {
                buttonTL.setText(buttonValues[row][column]);
            } else if (column == 1) {
                buttonTM.setText(buttonValues[row][column]);
            } else if (column == 2) {
                buttonTR.setText(buttonValues[row][column]);
            }
            break;
        case 1:
            if (column == 0) {
                buttonML.setText(buttonValues[row][column]);
            } else if (column == 1) {
                buttonMM.setText(buttonValues[row][column]);
            } else if (column == 2) {
                buttonMR.setText(buttonValues[row][column]);
            }
            break;
        case 2:
            if (column == 0) {
                buttonBL.setText(buttonValues[row][column]);
            } else if (column == 1) {
                buttonBM.setText(buttonValues[row][column]);
            } else if (column == 2) {
                buttonBR.setText(buttonValues[row][column]);
            }
            break;
        }

        gameObject.NextTurn();
    }

    public void reset() {
        // set button values to empty string
        for (String[] s : buttonValues) {
            s[0] = "";
            s[1] = "";
            s[2] = "";
        }
        updateButtons();

        isXTurn = true;
    }

    public WinType getWinStatus() {
        if (checkIfWon("X")) {
            return WinType.X_WIN;
        } else if (checkIfWon("O")) {
            return WinType.O_WIN;
        } else if (checkIfFilled()) {
            return WinType.TIE;
        } else {
            return WinType.NONE;
        }
    }

    private Boolean checkIfWon(String player) {
        if (buttonValues[0][0].equals(player)) {
            if ((buttonValues[0][1].equals(player) && buttonValues[0][2].equals(player))
                    || (buttonValues[1][0].equals(player) && buttonValues[2][0].equals(player))
                    || (buttonValues[1][1].equals(player) && buttonValues[2][2].equals(player))) {
                return true;
            }
        }
        if (buttonValues[0][1].equals(player) && buttonValues[1][1].equals(player)
                && buttonValues[2][1].equals(player)) {
            return true;
        }
        if (buttonValues[1][0].equals(player) && buttonValues[1][1].equals(player)
                && buttonValues[1][2].equals(player)) {
            return true;
        }
        if (buttonValues[2][0].equals(player)) {
            if ((buttonValues[1][1].equals(player) && buttonValues[0][2].equals(player))
                    || (buttonValues[2][1].equals(player) && buttonValues[2][2].equals(player))) {
                return true;
            }
        }
        return false;
    }

    private Boolean checkIfFilled()
    {
        boolean isFilled = true;
        for (String[] s : buttonValues) {
            for(String value : s)
            {
                isFilled = isFilled && !value.equals("");
            }
        }
        return isFilled;
    }

    public void enableButtons() {
        buttonTL.setEnabled(true);
        buttonTM.setEnabled(true);
        buttonTR.setEnabled(true);
        buttonML.setEnabled(true);
        buttonMM.setEnabled(true);
        buttonMR.setEnabled(true);
        buttonBL.setEnabled(true);
        buttonBM.setEnabled(true);
        buttonBR.setEnabled(true);
    }

    public void disableButtons() {
        buttonTL.setEnabled(false);
        buttonTM.setEnabled(false);
        buttonTR.setEnabled(false);
        buttonML.setEnabled(false);
        buttonMM.setEnabled(false);
        buttonMR.setEnabled(false);
        buttonBL.setEnabled(false);
        buttonBM.setEnabled(false);
        buttonBR.setEnabled(false);

    }

    // Constructor
    public BoardPanel(GameGUI parent) {
        // Set up parent
        gameObject = parent;

        // Set up buttons
        Font buttonFont = new Font("Arial", Font.BOLD, 24);

        buttonTL = new JButton();
        buttonTL.addActionListener(new ticTacToeListener(0, 0));
        buttonTL.setEnabled(false);
        buttonTL.setFont(buttonFont);        

        buttonTM = new JButton();
        buttonTM.addActionListener(new ticTacToeListener(0, 1));
        buttonTM.setEnabled(false);
        buttonTM.setFont(buttonFont);        

        buttonTR = new JButton();
        buttonTR.addActionListener(new ticTacToeListener(0, 2));
        buttonTR.setEnabled(false);
        buttonTR.setFont(buttonFont);        

        buttonML = new JButton();
        buttonML.addActionListener(new ticTacToeListener(1, 0));
        buttonML.setEnabled(false);
        buttonML.setFont(buttonFont);        

        buttonMM = new JButton();
        buttonMM.addActionListener(new ticTacToeListener(1, 1));
        buttonMM.setEnabled(false);
        buttonMM.setFont(buttonFont);        

        buttonMR = new JButton();
        buttonMR.addActionListener(new ticTacToeListener(1, 2));
        buttonMR.setEnabled(false);
        buttonMR.setFont(buttonFont);        

        buttonBL = new JButton();
        buttonBL.addActionListener(new ticTacToeListener(2, 0));
        buttonBL.setEnabled(false);
        buttonBL.setFont(buttonFont);        

        buttonBM = new JButton();
        buttonBM.addActionListener(new ticTacToeListener(2, 1));
        buttonBM.setEnabled(false);
        buttonBM.setFont(buttonFont);        

        buttonBR = new JButton();
        buttonBR.addActionListener(new ticTacToeListener(2, 2));
        buttonBR.setEnabled(false);
        buttonBR.setFont(buttonFont);        

        // Set layout to a grid layout and add items
        setLayout(new GridLayout(3, 3));
        this.add(buttonTL);
        this.add(buttonTM);
        this.add(buttonTR);
        this.add(buttonML);
        this.add(buttonMM);
        this.add(buttonMR);
        this.add(buttonBL);
        this.add(buttonBM);
        this.add(buttonBR);
    }
}