import javax.swing.*;
import javax.swing.JPanel;
import java.util.*;
import javax.swing.Timer;
import java.awt.event.*;

public class ParalaxPanel extends JPanel implements ActionListener{
    private int delay = 10;
    protected Timer timer;

    private ArrayList<PXObject> pxObjects = new ArrayList<PXObject>();

    public ParalaxPanel()
    {
      timer = new Timer(delay, this);
      timer.start(); // starts timer
    }

    // runs when the timer fires
    public void actionPerformed(ActionEvent e)
    {
      System.out.println("TIMER");
      repaint();
    }
}
