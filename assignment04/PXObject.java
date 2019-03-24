import java.awt.Graphics;
import java.awt.Color;

public abstract class PXObject {
    protected int moveMult;

    public abstract void paint(int mouseDX, int mouseDY, Graphics g);
}
