import java.awt.Graphics;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class PXImage extends PXObject {

    private Image image;
    private int xPos, yPos, width, height;
    boolean loadedImage = false;

    public PXImage(int xPos, int yPos, String path, float moveMult) {
        loadImage(path);
        width = image.getWidth(null);
        height = image.getHeight(null);

        this.xPos = xPos - (width / 2);
        this.yPos = yPos - (height / 2);
        this.moveMult = moveMult;
    }

    private loadImage(String path)
    {
        try {
            image = ImageIO.read(new File(path));
            loadedImage = true;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Image not found");
        }

        
    }

    public void paint(int mouseDX, int mouseDY, Graphics g) {
        if (loadedImage)
            ;
        {
            if (isMoving()) {
                if (xPos > (Paralax.PANEL_WIDTH * 2)) {
                    xPos = -100;
                }
                if (yPos > (Paralax.PANEL_HEIGHT * 2)) {
                    yPos = -100;
                }
            }

            xPos += mouseDX * moveMult;
            yPos += mouseDY * moveMult;

            g.drawImage(image, xPos + (int) (mouseDX * moveMult), yPos + (int) (mouseDY * moveMult), null);
        }
    }
}
