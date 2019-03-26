import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.util.*;
import javax.swing.Timer;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.*;
import java.awt.Color;
import java.io.File;
import java.io.IOException;

public class ParalaxPanel extends JPanel implements ActionListener {
    private int delay = 10;

    protected Timer refreshTimer;
    protected Timer addItemTimer;

    private int xDist;
    private int yDist;
    private int currentX;
    private int currentY;
    private int lineX;
    private int lineY;
    private boolean isDragged;
    private boolean eagleShown;
    private int itemsShown = 0;

    private int birdX = 0; // x position
    private int birdY = 0; // y position
    private int birdDX = 2; // increment amount (x coord)
    private int birdDY = 2; // increment amount (y coord)

    private Image birdImage;

    private ArrayList<PXObject> pxObjects;

    public ParalaxPanel() {
        xDist = 0;
        yDist = 0;
        eagleShown = false;
        isDragged = false;

        pxObjects = new ArrayList<PXObject>();
        try {
            birdImage = ImageIO.read(new File("merica.png"));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Failed to load merica.png");
        }

        // Add mouse listeners
        addMouseMotionListener(new ParalaxMotionListener());
        addMouseListener(new ParalaxMouseListner());

        refreshTimer = new Timer(delay, this);
        addItemTimer = new Timer(500, new DisplayMoreItemsListener());
        refreshTimer.start(); // starts timer
        addItemTimer.start();
    }

    // runs when the timer fires
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    /**
     * Paints all objects in pxObjects
     *
     * @param g Graphics object for the component
     */
    public void paint(Graphics g) {

        for (int i = 0; i < itemsShown; i++) {
            pxObjects.get(i).paint(xDist, yDist, g);
        }

        if (isDragged) {
            g.drawLine(lineX, lineY, currentX, currentY);
        }

        if (eagleShown) {
            if (birdX < 0)
                birdDX = Math.abs(birdDX);
            if (birdX > getWidth() - 200)
                birdDX = -Math.abs(birdDX);
            if (birdY < 0)
                birdDY = Math.abs(birdDY);
            if (birdY > getHeight() - 84)
                birdDY = -Math.abs(birdDY);

            birdX += birdDX;
            birdY += birdDY;
            g.drawImage(birdImage, birdX, birdY, null);
        }

        if (isDragged) {
            g.setColor(Color.decode("0xff00d2"));
            g.drawLine(lineX, lineY, currentX, currentY);
        }

    }

    private class ParalaxMouseListner implements MouseListener {
        public void mouseClicked(MouseEvent e) {
            eagleShown = !eagleShown;
        }

        public void mouseExited(MouseEvent e) {
            xDist = 0;
            yDist = 0;
        }

        public void mouseEntered(MouseEvent e) {
            xDist = e.getX() - (Paralax.PANEL_WIDTH / 2);
            yDist = e.getY() - (Paralax.PANEL_HEIGHT / 2);
        }

        public void mousePressed(MouseEvent e) {
            lineX = e.getX();
            lineY = e.getY();
        }

        public void mouseReleased(MouseEvent e) {
            isDragged = false;
        }
    }

    private class ParalaxMotionListener implements MouseMotionListener {
        // unused
        public void mouseDragged(MouseEvent e) {
            isDragged = true;
            currentX = e.getX();
            currentY = e.getY();

        }

        public void mouseMoved(MouseEvent e) {
            xDist = e.getX() - (Paralax.PANEL_WIDTH / 2);
            yDist = e.getY() - (Paralax.PANEL_HEIGHT / 2);
            currentX = e.getX();
            currentY = e.getY();
        }
    }

    private class DisplayMoreItemsListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(itemsShown < pxObjects.size())
            {
                itemsShown++;
            }
        }
    }

    /**
     * adds a paralax object to the Paralax Panel
     * 
     * @param object the object to be added
     */
    public void addPXObject(PXObject object) {
        pxObjects.add(object);
    }

}
