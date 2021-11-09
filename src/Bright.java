/*
    Judul : Operasi-Operasi Dasar Citra dan Pendeteksian Tepi (Edge Detection)
    Bahasa : Java
    Kelas : TI 5 Reguler C
    Anggota :
        - Josie G.F Purba (09021281924044)
        - M. Friza Dwi Aditya Frinison (09021181924018)
        - Abang Muhammad Bagus (09021281924044)
    https://www2.eecs.berkeley.edu/Research/Projects/CS/vision/bsds/
*/

import java.io.File;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import javax.imageio.ImageIO;
import javax.swing.JFrame;


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
            ImageIO.write(dest,"jpeg",new File("result.jpg"));
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private BufferedImage changeBrightness(BufferedImage src, float val) {
        RescaleOp brighterOp = new RescaleOp(val, 0, null);
        return brighterOp.filter(src,null);
    }

    public static void main(String[] args) throws Exception {
        JFrame jf = new JFrame("Image Brightening");
        Bright obj = new Bright();
        jf.getContentPane().add(obj);
        jf.setVisible(true);
        jf.setSize(481,321);
        jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
    }
}
