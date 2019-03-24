import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Color;

public class PXTriangle extends PXObject {

    private int[] xVerts, yVerts;
    private Polygon gPolygon;
    private Color color;

    public PXTriangle(int x1, int y1, int x2, int y2, int x3, int y3, int moveMult, Color color) {
        xVerts = new int[] { x1, x2, x3 };
        yVerts = new int[] { y1, y2, y3 };


        this.moveMult = moveMult;
        this.color = color;
    }

    public void paint(int mouseDX, int mouseDY, Graphics g) {
        for(int i = 0; i < 3; i++)
        {
            xVerts[i] += mouseDX * moveMult;
            yVerts[i] += mouseDY * moveMult;
        }

        g.setColor(color);
        g.fillPolygon(xVerts, yVerts, 3);
    }

}
