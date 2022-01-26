package greenScreen;

/**
 * RGB channel conversions referenced from:
 * https://dyclassroom.com/image-processing-project/how-to-get-and-set-pixel-value-in-java
 */

import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Picture {

  BufferedImage myBufferedImage;
  private Pixel[][] myImageMatrix;

  public Picture(String filename) {
    try {
      File infile = new File(filename);
      myBufferedImage = ImageIO.read(infile);
    } catch(IOException e) {
      System.out.println(e);
    }

    int numRows = myBufferedImage.getHeight();
    int numCols = myBufferedImage.getWidth();
    myImageMatrix = new Pixel[numRows][numCols];
    for (int row = 0; row < numRows; row++) {
      for (int col = 0; col < numCols; col++) {
        int rgb = myBufferedImage.getRGB(col, row);
        int r = (rgb>>16) & 0xff;
        int g = (rgb>>8) & 0xff;
        int b = rgb & 0xff;
        myImageMatrix[row][col] = new Pixel(r, g, b);
      }
    }
  }

  public Picture(Pixel[][] imageMatrix) {
    myImageMatrix = imageMatrix;
    myBufferedImage = new BufferedImage(myImageMatrix[0].length, myImageMatrix.length, 5);
  }

  public Pixel[][] getImageMatrix() {
    return myImageMatrix;
  }

  public void save(String filename) {
    for (int row = 0; row < myBufferedImage.getHeight(); row++) {
      for (int col = 0; col < myBufferedImage.getWidth(); col++) {
        int alpha = (myBufferedImage.getRGB(col, row)>>24) & 0xff;
        Pixel pixel = myImageMatrix[row][col];
        int rgb = (alpha<<24) | (pixel.getR()<<16) | (pixel.getG()<<8) | pixel.getB();
        myBufferedImage.setRGB(col, row, rgb);
      }
    }

    try { 
      File outfile = new File(filename); 
      ImageIO.write(myBufferedImage, "png", outfile); 
    } catch(IOException e) { 
      System.out.println(e); 
    } 
  }

  public static void main(String[] args) {
    Picture pic = new Picture("utep_cs_building.jpeg");
    System.out.println(pic.getImageMatrix().length + ", " + pic.getImageMatrix()[0].length);
    pic.save("test.png");
  }
}