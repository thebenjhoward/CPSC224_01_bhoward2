import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Color;

public class PXTriangle extends PXObject {

    private Polygon poly, currPoly;
    private Color color;

    /**
     * Creates a new PXTriangle
     * @param x1 x-value of vertex 1
     * @param y1 y-value of vertex 1
     * @param x2 x-value of vertex 2
     * @param y2 y-value of vertex 2
     * @param x3 x-value of vertex 3
     * @param y3 y-value of vertex 3
     * @param moveMult intensity of paralax effect
     * @param color color of the triangle
     */
    public PXTriangle(int x1, int y1, int x2, int y2, int x3, int y3, float moveMult, Color color) {

        poly = new Polygon(new int[] { x1, x2, x3 }, new int[] { y1, y2, y3 }, 3);
        currPoly = new Polygon(new int[] { x1, x2, x3 }, new int[] { y1, y2, y3 }, 3);

        this.moveMult = moveMult;
        this.color = color;
    }

    public void paint(int mouseDX, int mouseDY, Graphics g) {

        int[] currCentroid = getCentroid(currPoly);

        if (isMoving()) {

            if (currCentroid[0] > (Paralax.PANEL_WIDTH * 2)) {
                currPoly = new Polygon(poly.xpoints, poly.ypoints, poly.npoints);
            }
            if (currCentroid[1] > (Paralax.PANEL_HEIGHT * 2)) {
                currPoly = new Polygon(poly.xpoints, poly.ypoints, poly.npoints);
            }
        }

        Polygon destPolygon = new Polygon(poly.xpoints, poly.ypoints, poly.npoints);
        for (int i = 0; i < poly.npoints; i++) {
            destPolygon.xpoints[i] += (mouseDX * moveMult);
            destPolygon.ypoints[i] += (mouseDY * moveMult);
        }

        for (int i = 0; i < poly.npoints; i++) {
            if (Math.abs(destPolygon.xpoints[i] - currPoly.xpoints[i]) > (int) (mouseDX * moveMult) / 12) {
                currPoly.xpoints[i] += (destPolygon.xpoints[i] - currPoly.xpoints[i]) / 12;
            } else {
                currPoly.xpoints[i] = destPolygon.xpoints[i];
            }

            if (Math.abs(destPolygon.ypoints[i] - currPoly.ypoints[i]) > (int) (mouseDY * moveMult) / 12) {
                currPoly.ypoints[i] += (destPolygon.ypoints[i] - currPoly.ypoints[i]) / 12;
            } else {
                currPoly.ypoints[i] = destPolygon.ypoints[i];
            }
        }

        g.setColor(color);
        g.fillPolygon(currPoly);
    }

}
