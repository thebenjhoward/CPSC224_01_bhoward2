import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Color;

public class PXPolygon extends PXObject {

    private Polygon poly;
    private Polygon currPoly;
    private Color color;

    /**
     * default constructor for PXPolygon
     * @param poly polygon to be displayed
     * @param moveMult intensity of paralax effect
     * @param color color of the polygon
     */
    public PXPolygon(Polygon poly, float moveMult, Color color) {
        this.poly = poly;
        this.moveMult = moveMult;
        this.color = color;
    }

    public void paint(int mouseDX, int mouseDY, Graphics g) {
        int[] centroid = getCentroid(currPoly);

        if (isMoving()) {

            if (centroid[0] > (Paralax.PANEL_WIDTH * 2)) {
                currPoly = poly;
            }
            if (centroid[1] > (Paralax.PANEL_HEIGHT * 2)) {
                currPoly = poly;
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
