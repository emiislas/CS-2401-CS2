package greenScreen;

public class Pixel {

  private int myR, myG, myB;

  public Pixel(int r, int g, int b) {
    setR(r);
    setG(g);
    setB(b);
  }

  public int getR() {
    return myR;
  }

  public int getG() {
    return myG;
  }

  public int getB() {
    return myB;
  }

  public void setR(int r) {
    myR = clampColorValue(r);
  }

  public void setG(int g) {
    myG = clampColorValue(g);
  }

  public void setB(int b) {
    myB = clampColorValue(b);
  }
  
  // Computes the brightness (grayscale value) of a Pixel;
  public int getBrightness() {
      return (myR + myG + myB) / 3;
  }

  // Keep RGB values in the range [0, 255]
  private static int clampColorValue(int val) {
    return Math.min(255, Math.max(0, val));
  }
  
  // A distance of less than 300 is a fairly similar distance
  public double distanceTo(Pixel p) {
      return Math.pow(myR - p.getR(), 2) + Math.pow(myG - p.getG(), 2) + Math.pow(myB - p.getB(), 2);
  }
}