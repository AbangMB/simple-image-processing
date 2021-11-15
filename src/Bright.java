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

import java.io.IOException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import javax.imageio.ImageIO;
import javax.swing.JFrame;


public class Bright extends JPanel {
    BufferedImage LoadImage(String FileName) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(Bright.class.getResource(FileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return img;
    }

    BufferedImage changeBrightness(BufferedImage LoadImage, float val) {
        RescaleOp brighterOp = new RescaleOp(val, 0, null);
        return brighterOp.filter(LoadImage, null);
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        BufferedImage img = changeBrightness(LoadImage("Image/Color/14037.jpg"),2.9f); // To change Brightness function
        g2d.drawImage(img,0,0,this);
    }

    public static void main(String[] args) throws Exception {
        JFrame jf = new JFrame("Image Brightening");
        jf.add(new Bright());
        jf.setVisible(true);
        jf.setSize(481,321);
        jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
    }
}