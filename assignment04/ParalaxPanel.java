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
        int mouseDX = 0;
        int mouseDY = 0;

        ArrayList<PXObject> pxObjects = new ArrayList<PXObject>();

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
            obj.paint(mouseDX, mouseDY, g);
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
            mouseX = e.getX();
            mouseY = e.getY();
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
            mouseDX += e.getX() - mouseX;
            mouseDY += e.getY() - mouseY;

            mouseX = e.getX();
            mouseY = e.getY();
        }
    }

    public void addPXObject(PXObject object) {
        pxObjects.add(object);
    }

}
