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
}
