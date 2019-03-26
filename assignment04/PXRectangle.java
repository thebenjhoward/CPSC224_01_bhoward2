import java.awt.Graphics;
import java.awt.Color;


public class PXRectangle extends PXObject {
    private int width, height, xPos, yPos, currX, currY;
    private Color color;

    /**
     * default constructor for PXRectangle
     * @param width width of the rectangle
     * @param height height of the rectangle
     * @param xPos x-position of the center of the rectangle
     * @param yPos y-position of the center of the rectangle
     * @param moveMult sets how intense the paralax effect is
     * @param color sets the color of the rectangle
     */
    public PXRectangle(int width, int height, int xPos, int yPos, float moveMult, Color color) {
        this.width = width;
        this.height = height;
        this.xPos = currX = xPos - (width / 2);
        this.yPos = currY = yPos - (height / 2);

        this.moveMult = moveMult;
        this.color = color;
    }

    public void paint(int mouseDX, int mouseDY, Graphics g) {
        if (isMoving()) {
            if (xPos > (Paralax.PANEL_WIDTH * 2)) {
                xPos = currX = -100;
            }
            if (yPos > (Paralax.PANEL_HEIGHT * 2)) {
                yPos = currY = -100;
            }
        }

        xPos += dx;
        currX += dx;
        yPos += dy;
        currY += dy;

        int destX = xPos + (int) (mouseDX * moveMult);
        int destY = yPos + (int) (mouseDY * moveMult);

        if (Math.abs(destX - currX) > (int) (mouseDX * moveMult) / 12) {
            currX += (destX - currX) / 12;
        } else {
            currX = destX;
        }

        if (Math.abs(destY - currY) > (int) (mouseDY * moveMult) / 12) {
            currY += (destY - currY) / 12;
        } else {
            currY = destY;
        }

        g.setColor(color);
        g.fillRect(currX, currY, width, height);

    }
}
