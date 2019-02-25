import javax.swing.*;
import java.awt.event.*;

public class Test extends JFrame
{
    BoardPanel b;

    public Test()
    {
        b = new BoardPanel();
        this.setSize(500, 600);

        JPanel mainPanel = new JPanel();

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        
        JPanel buttonPanel = new JPanel();
        JButton resetButton = new JButton("Reset");
        JButton enableButton = new JButton("Enable");
        JButton getWinButton = new JButton("Get Winner");
        
        resetButton.addActionListener(new ResetListener());
        enableButton.addActionListener(new EnableListener());
        getWinButton.addActionListener(new TestListener());

        buttonPanel.add(resetButton);
        buttonPanel.add(enableButton);
        buttonPanel.add(getWinButton);

        b.enableButtons();
        mainPanel.add(b);
        mainPanel.add(buttonPanel);

        this.add(mainPanel);

        this.setVisible(true);
    }

    private class ResetListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            b.reset();
        }
    }

    private class EnableListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            b.enableButtons();
        }
    }

    private class TestListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            JOptionPane.showMessageDialog(null, b.getWinStatus().toString());
        }
    }

    public static void main(String[] args)
    {
        new Test();
    }
}