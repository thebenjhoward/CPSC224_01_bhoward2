import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Color;

public class PXPolygon extends PXObject {

    private Polygon poly;
    private Color color;

    public PXPolygon(Polygon poly, float moveMult, Color color) {
        this.poly = poly;
        this.moveMult = moveMult;
        this.color = color;
    }

    public void paint(int mouseDX, int mouseDY, Graphics g) {
        if (isMoving()) {
            int xPos = 0, yPos = 0;
            for (int i = 0; i < poly.npoints; i++) {
                xPos += poly.xpoints[i];
                yPos += poly.ypoints[i];
            }
            xPos /= poly.npoints;
            yPos /= poly.npoints;

            if (xPos > (Paralax.PANEL_WIDTH * 2)) {
                xPos = -100;
            }
            if (yPos > (Paralax.PANEL_HEIGHT * 2)) {
                yPos = -100;
            }
        }

        poly.translate((int) (mouseDX * moveMult) + dx, (int) (mouseDY * moveMult) + dy);

        g.setColor(color);
        g.fillPolygon(poly);
    }

}
