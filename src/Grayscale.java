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
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;


public class Grayscale{
  public static void main(String args[]) throws IOException{
    BufferedImage img = null;
    File f = null;

    //Membaca gambar
    try {
      // Pastikan direktori gambar benar
      f = new File("241004.jpg");
      img = ImageIO.read(f);
    } catch(IOException e){
      System.out.println(e);
    }

    //Mendapatkan lebar dan tinggi gambar
    int width = img.getWidth();
    int height = img.getHeight();

    //Mengubah ke skala abu-abu
    for(int y = 0; y < height; y++){
      for(int x = 0; x < width; x++){
        int p = img.getRGB(x,y);

        int a = (p>>24)&0xff;
        int r = (p>>16)&0xff;
        int g = (p>>8)&0xff;
        int b = p&0xff;

        //menghitung rata-rata
        int avg = (r+g+b)/3;

        //Mengganti nilai RGB dengan rata-rata
        p = (a<<24) | (avg<<16) | (avg<<8) | avg;

        img.setRGB(x, y, p);
      }
    }

    //Menulis gambar
    try {
      f = new File("Output.jpg");
      ImageIO.write(img, "jpg", f);
    } catch(IOException e){
      System.out.println(e);
    }
  }//akhir main
}//akhir class
