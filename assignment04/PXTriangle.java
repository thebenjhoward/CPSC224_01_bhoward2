import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Color;

public class PXTriangle extends PXObject {

    private Polygon triPoly;
    private Color color;

    public PXTriangle(int x1, int y1, int x2, int y2, int x3, int y3, float moveMult, Color color) {

        triPoly = new Polygon(new int[] { x1, x2, x3 }, new int[] { y1, y2, y3 }, 3);

        this.moveMult = moveMult;
        this.color = color;
    }

    public void paint(int mouseDX, int mouseDY, Graphics g) {

        if (isMoving()) {
            int xPos = 0, yPos = 0;
            for (int i = 0; i < 3; i++) {
                xPos += triPoly.xpoints[i];
                yPos += triPoly.ypoints[i];
            }
            xPos /= 3;
            yPos /= 3;
            
            if (xPos > (Paralax.PANEL_WIDTH * 2)) {
                xPos = -100;
            }
            if (yPos > (Paralax.PANEL_HEIGHT * 2)) {
                yPos = -100;
            }
        }
        
        for(int i = 0; i < triPoly.npoints; i++)
        {
            triPoly.xpoints[i] += (mouseDX * moveMult) + dx;
            triPoly.ypoints[i] += (mouseDY * moveMult) + dy;
        }

        g.setColor(color);
        g.fillPolygon(triPoly);
    }

}
