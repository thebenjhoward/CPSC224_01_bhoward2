import javax.swing.JPanel;
import java.util.*;
import javax.swing.Timer;
import java.awt.Graphics;
import java.awt.event.*;

public class ParalaxPanel extends JPanel implements ActionListener {
    private int delay = 10;
    protected Timer timer;
    private int xDist;
    private int yDist;
    private int currentX;
    private int currentY;
    private int lineX;
    private int lineY;

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

    /**Paints all objects in pxObjects
     * @param g Graphics object for the component */
    public void paint(Graphics g) {
        super.paint(g); // call superclass's paintComponent

        if(drawShape)
          g.drawRect(currentX, currentY, 10, 10);

        if(dragged){
          g.drawLine(lineX, lineY, currentX, currentY);
        }

        for (PXObject obj : pxObjects) {
            obj.paint(xDist, yDist, g);
        }

    }

    private class ParalaxMouseListner implements MouseListener {
        public void mouseClicked(MouseEvent e) {
          drawShape = true;
        }

        public void mouseExited(MouseEvent e) {

        }

        public void mouseEntered(MouseEvent e) {
            xDist = e.getX() - 500;
            yDist = e.getY() - 500;
        }

        public void mousePressed(MouseEvent e) {
          lineX = e.getX();
          lineY = e.getY();
          repaint();
        }

        public void mouseReleased(MouseEvent e) {
          drawShape = true;
          dragged = false;
          repaint();
        }
    }

    private class ParalaxMotionListener implements MouseMotionListener {
        // unused
        public void mouseDragged(MouseEvent e) {
            dragged = true;
            currentX = e.getX();
            currentY = e.getY();
            repaint();

        }

        public void mouseMoved(MouseEvent e) {
            xDist = e.getX() - 500;
            yDist = e.getY() - 500;
            currentX = e.getX();
            currentY = e.getY();
        }
    }

    public void addPXObject(PXObject object) {
        pxObjects.add(object);
    }

}
