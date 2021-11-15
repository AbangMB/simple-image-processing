import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.io.IOException;
import java.awt.geom.AffineTransform;
// import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Geometric extends JPanel {
    BufferedImage LoadImage(String FileName) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(Geometric.class.getResource(FileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return img;
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        AffineTransform at = new AffineTransform();
        BufferedImage img = LoadImage("Image/Color/14037.jpg");
        
        // Translation (Translate)
        // at.translate(100, 100);

        // Rotation (Rotate)
        // at.rotate(Math.toRadians(90), img.getWidth()/2, img.getHeight()/2);

        // Scaling (Scale)
        // at.scale(2, 2);

        // Flipping (Reflect)
        // img = flipImage(img);

        g2d.drawImage(img, at, null);
    }

    // BufferedImage flipImage(BufferedImage LoadImage) {
    //     // Flip Image Vertically
    //     // AffineTransform ty = AffineTransform.getScaleInstance(1, -1);
    //     // ty.translate(0, -LoadImage.getHeight(null));
    //     // AffineTransformOp op = new AffineTransformOp(ty, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);

    //     // Flip Image Horizontally
    //     // AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
    //     // tx.translate(-LoadImage.getWidth(), 0);
    //     // AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
        
    //     // return op.filter(LoadImage, null);
    // }

    public static void main(String[] args) throws IOException {
        JFrame jf = new JFrame("Geometric Operation");
        jf.add(new Geometric());
        jf.setVisible(true);
        jf.setSize(481,321);
        jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
    }
}
