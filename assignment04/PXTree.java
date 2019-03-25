import java.awt.Graphics;

public class PXTree extends PXObject {
    public PXRectangle trunk;
    public PXTriangle tree;

    private PXTree(PXRectangle trunk, PXTriangle tree) {
        this.trunk = trunk;
        this.tree = tree;
    }

    public static PXTree createTree(PXRectangle trunk, PXTriangle tree) {
        return new PXTree(trunk, tree);
    }

    public void setMovement(int dx, int dy) {
        tree.setMovement(dx, dy);
        trunk.setMovement(dx, dy);
    }

    public void paint(int MouseDX, int MouseDY, Graphics g) {
        trunk.paint(MouseDX, MouseDY, g);
        tree.paint(MouseDX, MouseDY, g);
    }
}