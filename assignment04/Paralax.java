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

    /**
     * populates a paralax panel with the scene
     * @param pPanel the panel to be populated
     */
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
        PXRectangle groundRect = new PXRectangle(960, 240, 320, 400, 0.15f, Color.GREEN);
        pPanel.addPXObject(groundRect);
        
        //trees
        for(int i = 0; i < 16; i++)
        {
            pPanel.addPXObject(PXObject.CreateTree(50, 100, 50 * i, 280, 0.15f, Color.decode("0x0d590d")));
        }
        for(int i = 0; i < 8; i++)
        {
            pPanel.addPXObject(PXObject.CreateTree(80, 160, 100 * i, 300, 0.25f, Color.decode("0x208020")));
        }

        //clouds
        PXImage cloud1 = new PXImage(0, 120, "cloud01.png", 0.0f);
        cloud1.setMovement(2, 0);
        pPanel.addPXObject(cloud1);
        PXImage cloud2 = new PXImage(320, 120, "cloud02.png", 0.0f);
        cloud2.setMovement(1, 0);
        pPanel.addPXObject(cloud2);
        PXImage cloud3 = new PXImage(640, 120, "cloud03.png", 0.0f);
        cloud3.setMovement(3, 0);
        pPanel.addPXObject(cloud3);



    }

}
