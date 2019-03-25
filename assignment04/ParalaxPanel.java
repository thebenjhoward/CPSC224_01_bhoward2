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
    private int xDist;
    private int yDist;

    private ArrayList<PXObject> pxObjects;

    public ParalaxPanel() {
        xDist = 0;
        yDist = 0;

        pxObjects = new ArrayList<PXObject>();

        // Add mouse listeners
        addMouseMotionListener(new ParalaxMotionListener());
        addMouseListener(new ParalaxMouseListner());

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
            obj.paint(xDist, yDist, g);
        }

        mouseDX = mouseDY = 0;
    }

    private class ParalaxMouseListner implements MouseListener {
        public void mouseClicked(MouseEvent e) {
            // not implemented
        }

        public void mouseExited(MouseEvent e) {
            // not implemented
        }

        public void mouseEntered(MouseEvent e) {
            xDist = e.getX() - 500;
            yDist = e.getY() - 500;
        }

        public void mousePressed(MouseEvent e) {
            // not implemented
        }

        public void mouseReleased(MouseEvent e) {
            // not implemented
        }
    }

    private class ParalaxMotionListener implements MouseMotionListener {
        // unused
        public void mouseDragged(MouseEvent e) {
        }

        public void mouseMoved(MouseEvent e) {
            xDist = e.getX() - 500;
            yDist = e.getY() - 500;
        }
    }

    public void addPXObject(PXObject object) {
        pxObjects.add(object);
    }

}
