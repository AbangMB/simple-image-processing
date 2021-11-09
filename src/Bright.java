import java.io.File;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import javax.imageio.ImageIO;

public class Bright extends JPanel {
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;

        try {
            // Reading Image From File
            BufferedImage src = ImageIO.read(getClass().getResource("Image/Color/14037.jpg"));

            // Passing Source Image and brightening it by 50%-value of 1.0f means original image brightness
            BufferedImage dest = changeBrightness(src,1.5f); // To change Brightness function

            // Drawing New Image On Panel
            g2d.drawImage(dest,0,0,this);

            // Writing New Image to a file in jpeg format
            ImageIO.write(dest,"jpeg",new File("simple-image-processing/src/Image/Result/result.jpg"));
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private BufferedImage changeBrightness(BufferedImage src, float val) {
        RescaleOp brighterOp = new RescaleOp(val, 0, null);
        return brighterOp.filter(src,null);
    }
}
