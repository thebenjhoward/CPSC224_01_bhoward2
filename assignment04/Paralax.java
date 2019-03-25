import java.awt.event.*;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.Timer;

public class Paralax {

    public static final int PANEL_WIDTH = 1000;
    public static final int PANEL_HEIGHT = 1000;

    public static void main(String args[]) {
        JFrame frame = new JFrame("Paralax");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ParalaxPanel pPanel = new ParalaxPanel();
        populateParalax(pPanel);

        frame.add(pPanel);
        frame.setSize(PANEL_WIDTH, PANEL_HEIGHT);
        frame.setVisible(true);
    }

    private static void populateParalax(ParalaxPanel pPanel)
    {
        PXRectangle rect1 = new PXRectangle(150, 150, 500, 500, 0.1f, Color.BLUE);
        PXRectangle rect2 = new PXRectangle(600, 300, 100, 100, 0.0f, Color.RED);
        PXTriangle tri1 = new PXTriangle(500, 300, 300, 500, 700, 500, 0.1f, Color.GREEN);
        rect2.setMovement(1, 0);

        pPanel.addPXObject(rect1);
        //pPanel.addPXObject(rect2);
        pPanel.addPXObject(tri1);
    }

}
