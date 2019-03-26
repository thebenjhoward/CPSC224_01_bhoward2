import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class PXImage extends PXObject {

    private Image image;
    private int xPos, yPos, currX, currY, width, height;
    boolean loadedImage = false;

    /**
     * default constructor for PXImage
     * @param xPos x-position of the center of the image
     * @param yPos y-position of the center of the image 
     * @param path path to the image
     * @param moveMult intensity of paralax effect
     */
    public PXImage(int xPos, int yPos, String path, float moveMult) {
        loadImage(path);
        width = image.getWidth(null);
        height = image.getHeight(null);

        this.xPos = currX = xPos - (width / 2);
        this.yPos = currY = yPos - (height / 2);
        this.moveMult = moveMult;
    }

    private void loadImage(String path) {
        try {
            image = ImageIO.read(new File(path));
            loadedImage = true;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Image not found");
        }

    }

    public void paint(int mouseDX, int mouseDY, Graphics g) {
        if (loadedImage) {
            if (isMoving()) {
                if (currX > (Paralax.PANEL_WIDTH * 4 / 3)) {
                    xPos = currX = -1 * width - 10;
                }
                if (currY > (Paralax.PANEL_HEIGHT * 4 / 3)) {
                    yPos = currY = -1 * height - 10;
                }
            }

            xPos += dx;
            currX += dx;
            yPos += dy;
            currY += dy;

            int destX = xPos + (int) (mouseDX * moveMult);
            int destY = yPos + (int) (mouseDY * moveMult);

            if (Math.abs(destX - currX) > (int) (mouseDX * moveMult) / 12) {
                currX += (destX - currX) / 12;
            } else {
                currX = destX;
            }

            if (Math.abs(destY - currY) > (int) (mouseDY * moveMult) / 12) {
                currY += (destY - currY) / 12;
            } else {
                currY = destY;
            }

            g.drawImage(image, currX, currY, null);
        }
    }
}
