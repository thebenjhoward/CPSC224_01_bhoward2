import java.awt.Color;
import javax.swing.JFrame;

public class Paralax {

    public static final int PANEL_WIDTH = 640; // max horiz: 960
    public static final int PANEL_HEIGHT = 480; // max vert: 720

    public static void main(String args[]) {
        JFrame frame = new JFrame("Paralax");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ParalaxPanel pPanel = new ParalaxPanel();
        populateParalax(pPanel);

        frame.add(pPanel);
        frame.setSize(PANEL_WIDTH, PANEL_HEIGHT);
        frame.setVisible(true);
    }

    private static void populateParalax(ParalaxPanel pPanel)
    {
        //sky
        PXRectangle skyRect = new PXRectangle(640, 480, 320, 240, 0.0f, Color.decode("0x00ccff"));
        pPanel.addPXObject(skyRect);
        PXEllipse sunEllipse = new PXEllipse(90, 90, 500, 120, 0.05f, Color.YELLOW);
        pPanel.addPXObject(sunEllipse);

        //mountains
        PXTriangle mount1 = new PXTriangle(160, 120, -160, 600, 480, 600, 0.075f, Color.decode("0xdcacd9"));
        pPanel.addPXObject(mount1);
        PXTriangle mount2 = new PXTriangle(480, 120, 160, 600, 800, 600, 0.075f, Color.decode("0xdcacd9"));
        pPanel.addPXObject(mount2);
        PXTriangle mount3 = new PXTriangle(320, 80, 0, 600, 640, 600, 0.1f, Color.decode("0xefe5ee"));
        pPanel.addPXObject(mount3);

        



        //ground
        PXRectangle groundRect = new PXRectangle(960, 240, 320, 480, 0.25f, Color.GREEN);
        pPanel.addPXObject(groundRect);
        
        for(int i = 0; i < 16; i++)
        {
            pPanel.addPXObject(PXObject.CreateTree(50, 100, 50 * i, 320, 0.15f, Color.decode("0x0d590d")));
        }
        for(int i = 0; i < 8; i++)
        {
            pPanel.addPXObject(PXObject.CreateTree(80, 160, 100 * i, 340, 0.25f, Color.decode("0x208020")));
        }


    }

}
