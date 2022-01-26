package greenScreen;

public class Blur {
    
    public static Pixel[][] blur(Pixel[][] image) {

        Pixel[][] result = new Pixel[image.length][image[0].length];
        
        for (int r = 0; r < image.length; r++){
            for (int c = 0; c < image[0].length; c++){
                int sumRed = 0;
                int sumBlue = 0;
                int sumGreen = 0;
                
                Pixel currentPixel = image[r][c];
                sumRed += currentPixel.getR();
                sumBlue += currentPixel.getB();
                sumGreen += currentPixel.getG();
                
                if (c > 0) {
                    Pixel leftNeighbor = image[r][c-1];
                    sumRed += leftNeighbor.getR();
                    sumBlue += leftNeighbor.getB();
                    sumGreen += leftNeighbor.getG();
                }

                if (r > 0){
                    Pixel aboveNeighbor = image[r-1][c];
                    sumRed += aboveNeighbor.getR();
                    sumBlue += aboveNeighbor.getB();
                    sumGreen += aboveNeighbor.getG();                    
                }
                if (c < image[0].length-1) {
                    Pixel rightNeighbor = image[r][c+1];
                    sumRed += rightNeighbor.getR();
                    sumBlue += rightNeighbor.getB();
                    sumGreen += rightNeighbor.getG();                    
                }
                
                if (r < image.length-1){
                    Pixel belowNeighbor = image[r+1][c];
                    sumRed += belowNeighbor.getR();
                    sumBlue += belowNeighbor.getB();
                    sumGreen += belowNeighbor.getG();                    
                }
                
                Pixel averagePixel = new Pixel(sumRed / 5, sumGreen / 5, sumBlue / 5);
                result[r][c] = averagePixel;
                
            }
        }
        return result;
        
        
        
        
    }
    
    public static void main(String[] args) {
        Picture pic = new Picture("utep_cs_building_small.jpeg");
        Pixel[][] original = pic.getImageMatrix();
        Pixel[][] blurred = blur(original);
        Picture result = new Picture(blurred);
        result.save("utep_cs_blur.png");
    }
}