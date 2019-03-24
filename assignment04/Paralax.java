import java.awt.event.*;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.Timer;

public class Paralax {
    public static void main(String args[]) {
        JFrame frame = new JFrame("Paralax");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ParalaxPanel pPanel = new ParalaxPanel();
        frame.add(pPanel);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
}
