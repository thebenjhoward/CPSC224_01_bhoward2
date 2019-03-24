import java.awt.Graphics;
import java.awt.Color;

public class PXRectangle extends PXObject {
    private int width, height, xPos, yPos;
    private Color color;

    public PXRectangle(int width, int height, int xPos, int yPos, int moveMult, Color color) {
        this.width = width;
        this.height = height;
        this.xPos = xPos - (width / 2);
        this.yPos = yPos - (height / 2);

        this.moveMult = moveMult;
        this.color = color;
    }

    public void paint(int mouseDX, int mouseDY, Graphics g) {
        this.xPos += mouseDX * moveMult;
        this.yPos += mouseDY * moveMult;

        g.setColor(color);
        g.fillRect(xPos, yPos, width, height);
    }
}
