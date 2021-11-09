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

import javax.swing.JPanel;
import javax.swing.JFrame;

public class Main extends JPanel {
    
    public static void main(String[] args) throws Exception {
        JFrame jf = new JFrame("Image Brightening");
        Bright obj = new Bright();
        jf.getContentPane().add(obj);
        jf.setVisible(true);
        jf.setSize(481,321);
        jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
    }
    
}

