import javax.swing.*;
import java.awt.event.*;

public class LatinTranslator extends JFrame
{
    private JPanel panel;
    private JLabel messageLabel;
    private JButton buttonLeft, buttonRight, buttonMiddle;

    private final int WINDOW_HEIGHT = 100;
    private final int WINDOW_WIDTH = 400;

    public LatinTranslator()
    {
        setTitle("Latin Translator");

        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        messageLabel = new JLabel("Click a button!");
        
        buttonLeft = new JButton("SINISTER");
        buttonMiddle = new JButton("MEDIUM");
        buttonRight = new JButton("DEXTER");

        buttonLeft.addActionListener(new LeftListener());
        buttonMiddle.addActionListener(new MiddleListener());
        buttonRight.addActionListener(new RightListener());

        panel = new JPanel();
        panel.add(messageLabel);
        panel.add(buttonLeft);
        panel.add(buttonMiddle);
        panel.add(buttonRight);

        add(panel);

        setVisible(true);

    }

    private class LeftListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            messageLabel.setText("Sinister = Left");
        }
    }

    private class MiddleListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            messageLabel.setText("Medium = Middle");
        }
    }

    private class RightListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            messageLabel.setText("Dexter = Right");
        }
    }

    public static void main(String[] args)
    {
        new LatinTranslator();
    }
}