import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Color;

public abstract class PXObject {
    protected float moveMult;       // the movement multiplier for the object
    protected int dx = 0, dy = 0;   // change in x and y per repaint

    /**
     * to be called whenever an object needs to be paint
     * 
     * @param mouseDX the distance from the mouse to the center
     * @param mouseDY the distance from the mouse to the center
     * @param g       graphics object for the component
     */
    public abstract void paint(int mouseDX, int mouseDY, Graphics g);

    /**
     * sets the movement value of the object
     * 
     * @param dx the change in x per repaint
     * @param dy the change in y per repaint
     */
    public void setMovement(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * Gets whether the object has a movement value set
     * 
     * @return true if dx and dy are both 0
     */
    public boolean isMoving() {
        return dx != 0 || dy != 0;
    }

    /**
     * Method used to automate making a tree.
     * 
     * @param width     the width of the tree
     * @param height    the height of the tree
     * @param x         x-position of the center of the tree
     * @param y         y- position of the center of the tree
     * @param moveMult  how intense the paralax effect is
     * @param treeColor the color of the top of the tree
     * @return a PXTree object with the given parameters
     */
    public static PXTree CreateTree(int width, int height, int x, int y, float moveMult, Color treeColor) {
        int treeX1 = x, treeY1 = y - (height / 2);
        int treeX2 = x - (width / 2), treeY2 = y + (height / 4);
        int treeX3 = x + (width / 2), treeY3 = y + (height / 4);

        int trunkW = width / 4;
        int trunkH = height / 2;
        int trunkX = x;
        int trunkY = y + (height / 4);

        PXTriangle tree = new PXTriangle(treeX1, treeY1, treeX2, treeY2, treeX3, treeY3, moveMult, treeColor);
        PXRectangle trunk = new PXRectangle(trunkW, trunkH, trunkX, trunkY, moveMult, Color.decode("0x805620"));

        return PXTree.createTree(trunk, tree);

    }

    /**
     * calculates the centroid of a given polygon
     * 
     * @param p the polygon to get a centroid of
     * @return integer array containing the x-value at [0] and the y-value at [1]
     */
    protected static int[] getCentroid(Polygon p) {
        int[] centroid = new int[] { 0, 0 };
        for (int i = 0; i < p.npoints; i++) {
            centroid[0] += p.xpoints[0];
            centroid[1] += p.ypoints[0];
        }
        centroid[0] /= p.npoints;
        centroid[1] /= p.npoints;

        return centroid;
    }
}
