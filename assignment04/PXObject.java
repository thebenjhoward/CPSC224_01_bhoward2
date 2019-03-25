import java.awt.Graphics;
import java.awt.Color;

public abstract class PXObject {
    protected float moveMult;
    protected int dx = 0, dy = 0;

    public abstract void paint(int mouseDX, int mouseDY, Graphics g);

    public void setMovement(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public boolean isMoving() {
        return dx != 0 || dy != 0;
    }

    public static PXTree CreateTree(int width, int height, int x, int y, float moveMult, Color treeColor) {
        int treeX1 = x, treeY1 = y - (height / 2);
        int treeX2 = x - (width / 2), treeY2 = y + (height / 4);
        int treeX3 = x + (width / 2), treeY3 = y + (height / 4);

        int trunkW = width / 4;
        int trunkH = height / 4;
        int trunkX = x;
        int trunkY = y + (3 * height / 8) - 1;

        PXTriangle tree = new PXTriangle(treeX1, treeY1, treeX2, treeY2, treeX3, treeY3, moveMult, treeColor);
        PXRectangle trunk = new PXRectangle(trunkW, trunkH, trunkX, trunkY, moveMult, Color.decode("0x805620"));

        return PXTree.createTree(trunk, tree);

    }
}
