import java.awt.Graphics;
import java.awt.Color;

public class PXRectangle extends PXObject {
    private int width, height, xPos, yPos;
    private Color color;

    public PXRectangle(int width, int height, int xPos, int yPos, float moveMult, Color color) {
        this.width = width;
        this.height = height;
        this.xPos = xPos - (width / 2);
        this.yPos = yPos - (height / 2);

        this.moveMult = moveMult;
        this.color = color;
    }

    public void paint(int mouseDX, int mouseDY, Graphics g) {
        if (isMoving()) {
            if(xPos > (Paralax.PANEL_WIDTH * 2))
            {
                xPos = -100;
            }
            if(yPos > (Paralax.PANEL_HEIGHT * 2))
            {
                yPos = -100;
            }
        }

        xPos += dx;
        yPos += dy;
        
        g.setColor(color);
        g.fillRect(xPos + (int)(mouseDX * moveMult), yPos + (int)(mouseDY * moveMult), width, height);
    }
}
