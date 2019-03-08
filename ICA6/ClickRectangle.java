import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ClickRectangle extends JFrame {
    private int currentX = 250, currentY = 250;
    private final int FRAME_WIDTH = 500, FRAME_HEIGHT = 500, RECT_WIDTH = 100, RECT_HEIGHT = 100;

    public void init() {
        setTitle("Woah! A rectangle");
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addMouseListener(new RectMouseListener());
        addMouseMotionListener(new RectMotionListener());
    }

    public void paint(Graphics g) {
        super.paint(g);

        g.setColor(Color.BLACK);
        g.drawRect(currentX - 50, currentY - 50, RECT_WIDTH, RECT_HEIGHT);
        g.setColor(Color.BLUE);
        g.fillRect(currentX - 50, currentY - 50, RECT_WIDTH, RECT_HEIGHT);
    }

    private class RectMouseListener implements MouseListener {
        public void mousePressed(MouseEvent e) {
            currentX = e.getX();
            currentY = e.getY();
            repaint();
        }

        public void mouseClicked(MouseEvent e) {

        }

        public void mouseReleased(MouseEvent e) {
        }

        public void mouseEntered(MouseEvent e) {
        }

        public void mouseExited(MouseEvent e) {
        }
    }

    private class RectMotionListener implements MouseMotionListener {
        public void mouseDragged(MouseEvent e) {

        }

        public void mouseMoved(MouseEvent e) {

        }
    }

    public ClickRectangle() {
        init();

        setVisible(true);
    }

    public static void main(String[] args) {
        new ClickRectangle();
    }
}