import javax.swing.*;
import javax.swing.JPanel;
import java.util.*;
import javax.swing.Timer;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.*;

public class ParalaxPanel extends JPanel implements ActionListener {
    private int delay = 10;
    protected Timer timer;
    private int mouseX;
    private int mouseY;
    private int mouseDX;
    private int mouseDY;

    private ArrayList<PXObject> pxObjects = new ArrayList<PXObject>();

    public ParalaxPanel() {
        int mouseX = 150;
        int mouseY = 150;
        int mouseDX = 0;
        int mouseDY = 0;

        ArrayList<PXObject> pxObjects = new ArrayList<PXObject>();
        // pxObjects.add()

        // Add a mouse motion listener
        addMouseMotionListener(new MyMouseMotionListener());

        timer = new Timer(delay, this);
        timer.start(); // starts timer
    }

    // runs when the timer fires
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    public void paint(Graphics g) {
        super.paint(g); // call superclass's paintComponent
        for (PXObject obj : pxObjects) {
            // obj.paint(mouseDX, mouseDY, g);
        }
    }

    private class MyMouseMotionListener implements MouseMotionListener {
        // unused
        public void mouseDragged(MouseEvent e) {
        }

        public void mouseMoved(MouseEvent e) {
            mouseDX = Math.abs(mouseX - e.getX());
            mouseDY = Math.abs(mouseY - e.getY());

            mouseX = e.getX();
            mouseY = e.getY();
        }
    }

}
