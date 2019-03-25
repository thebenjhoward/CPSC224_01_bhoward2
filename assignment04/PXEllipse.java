import java.awt.Graphics;
import java.awt.Color;

public class PXEllipse extends PXObject {

    Color color;
    int xPos, yPos, width, height;

    public PXEllipse(int width, int height, int xPos, int yPos, float moveMult, Color color) {
        this.width = width;
        this.height = height;
        this.xPos = xPos - (width / 2);
        this.yPos = yPos - (height / 2);

        this.moveMult = moveMult;
        this.color = color;
    }

    public void paint(int mouseDX, int mouseDY, Graphics g) {
        xPos += mouseDX * moveMult;
        yPos += mouseDY * moveMult;

        g.setColor(color);
        g.drawOval(xPos, yPos, width, height);
    }
}
