package main.java.cs1302.p2;

import main.java.cs1302.effects.Artsy;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class MyArtsy implements Artsy {

	/**
	 * Combines the two source images using a checkerboard effect
	 * 
	 * @param	src1		The first image to be combined
	 * @param	src2		The second image to be combined
	 * @param	checkSize	The size, in pixels, of each checkerboard square
	 * @return				The image resulting from the combination of the two source images.
	 */
    @Override
    public Image doCheckers(Image src1, Image src2, int checkSize) {
    	WritableImage checked = new WritableImage(300, 300);
    	PixelReader pr1 = src1.getPixelReader();
    	PixelReader pr2 = src2.getPixelReader();
    	PixelWriter pw = checked.getPixelWriter();
    	for(int x = 0; x < 300; x++){
    		for(int y = 0; y < 300; y++){
    			if(x == 0 && y == 0){
    				pw.setColor(x, y, pr1.getColor(x, y));
    			}
    			else if(((x / checkSize) % 2 == 0 && (y / checkSize) % 2 == 0) || ((x / checkSize) % 2 == 1 && (y / checkSize) % 2 == 1)){
    				pw.setColor(x, y, pr1.getColor(x, y));
    			}
    			else if((x / checkSize) % 2 == 1 || (y / checkSize) % 2 == 1){
    				pw.setColor(x, y, pr2.getColor(x, y));
    			}
    		}
    	}
    	System.out.println("CHECKER");
    	return checked;
    } // doCheckers

    /**
     * Combines two images by horizontal stripes of a given width
     * 
     * @param	src1			The first image to be combined
     * @param	src2			The second image to be combined
     * @param	stripeHeight	The height, in pixels, of each stripe
     * @return					The image resulting from the combination of the two source images
     */
    @Override
    public Image doHorizontalStripes(Image src1, Image src2, int stripeHeight) {
    	WritableImage striped = new WritableImage(300, 300);
    	PixelReader pr1 = src1.getPixelReader();
    	PixelReader pr2 = src2.getPixelReader();
    	PixelWriter pw = striped.getPixelWriter();
    	for(int x = 0; x < 300; x++){
    		for(int y = 0; y < 300; y++){
    			if (y == 0 || (y / stripeHeight) % 2 == 1){
    				pw.setColor(x, y, pr1.getColor(x, y));
    			}
    			else if ((y / stripeHeight) % 2 == 0) {
    				pw.setColor(x, y, pr2.getColor(x, y));
    			}
    		}
    	}
    	System.out.println("HORIZONTAL STRIPE");
    	return striped;
    } // doHorizontalStripes

    /**
     * Returns an image that is a copy of the source image rotated by the given degrees
     * 
     * @param	src	image to be rotated
     * @param	degrees	degrees to rotate the image by
     * @return	rotated version of the source image
     */
    @Override
    public Image doRotate(Image src, double degrees) {
    	double rads = Math.toRadians(degrees);
    	int width = (int) src.getWidth();
    	int height = (int) src.getHeight();
    	WritableImage rotated = new WritableImage(width, height);
    	PixelReader pr = src.getPixelReader();
    	PixelReader npr = rotated.getPixelReader();
    	PixelWriter pw = rotated.getPixelWriter();
    	for(int x = 0; x < width; x++){
    		for(int y = 0; y < height; y++){
    			int newX = (int) (((x - (width / 2))  * Math.cos(rads)) - ((y - (height / 2)) * Math.sin(rads)));
    			int newY = (int) (((x - (width / 2)) * Math.sin(rads)) + ((y - (height /2)) * Math.cos(rads)));
    			
    			newX = newX + (width / 2);
    			newY = newY + (height / 2);
    			
    			if(newX < width && newX >=0 && newY < height && newY >= 0){
    				pw.setColor(newX, newY, pr.getColor(x, y));
    			}
    		}
    	}
    	
    	for(int x = 0; x < width; x++){
    		for(int y = 0; y < height; y++){
    			if(npr.getArgb(x, y) == 0){
    				double averageRed = 0;
    				double averageGreen = 0;
    				double averageBlue = 0;
    				int count = 0;
    				
    				if(x - 1 >= 0){
    					count++;
    					averageRed = averageRed + npr.getColor(x - 1, y).getRed();
    					averageBlue = averageBlue + npr.getColor(x - 1, y).getBlue();
    					averageGreen = averageGreen + npr.getColor(x - 1, y).getGreen();
    				}
    				if(x + 1 < width){
    					count++;
    					averageRed = averageRed + npr.getColor(x + 1, y).getRed();
    					averageBlue = averageBlue + npr.getColor(x + 1, y).getBlue();
    					averageGreen = averageGreen + npr.getColor(x + 1, y).getGreen();
    				}
    				if(y - 1 >= 0){
    					count++;
    					averageRed = averageRed + npr.getColor(x, y - 1).getRed();
    					averageBlue = averageBlue + npr.getColor(x, y - 1).getBlue();
    					averageGreen = averageGreen + npr.getColor(x, y - 1).getGreen();
    				}
    				if(y + 1 < height){
    					count++;
    					averageRed = averageRed + npr.getColor(x, y + 1).getRed();
    					averageBlue = averageBlue + npr.getColor(x, y + 1).getBlue();
    					averageGreen = averageGreen + npr.getColor(x, y + 1).getGreen();
    				}
    				if(x - 1 >= 0 && y - 1 >= 0){
    					count++;
    					averageRed = averageRed + npr.getColor(x - 1, y - 1).getRed();
    					averageBlue = averageBlue + npr.getColor(x - 1, y - 1).getBlue();
    					averageGreen = averageGreen + npr.getColor(x - 1, y - 1).getGreen();
    				}
    				if(x - 1 >= 0 && y + 1 < height){
    					count ++;
    					averageRed = averageRed + npr.getColor(x - 1, y + 1).getRed();
    					averageBlue = averageBlue + npr.getColor(x - 1, y + 1).getBlue();
    					averageGreen = averageGreen + npr.getColor(x - 1, y + 1).getGreen();
    				}
    				if(x + 1 < width && y - 1 >= 0){
    					count++;
    					averageRed = averageRed + npr.getColor(x + 1, y - 1).getRed();
    					averageBlue = averageBlue + npr.getColor(x + 1, y - 1).getBlue();
    					averageGreen = averageGreen + npr.getColor(x + 1, y - 1).getGreen();
    				}
    				if(x + 1 < width && y + 1 < height){
    					count++;
    					averageRed = averageRed + npr.getColor(x + 1, y + 1).getRed();
    					averageBlue = averageBlue + npr.getColor(x + 1, y + 1).getBlue();
    					averageGreen = averageGreen + npr.getColor(x + 1, y + 1).getGreen();
    				}
    				
    				averageRed = averageRed / count;
    				averageGreen = averageGreen / count;
    				averageBlue = averageBlue / count;
   
    				Color averageColor = new Color(averageRed, averageGreen, averageBlue , 1);
    				pw.setColor(x, y, averageColor);
    			}
    		}
    	}
    	
    	System.out.println("ROTATE");
    	return rotated;
    } // doRotate

    /**
     * Combines the two images by using vertical stripes of a given width
     * 
     * @param	src1		The first image to be combined
     * @param	src2		The second image to be combined
     * @param	stripeWidth	The width, in pixels, of each stripe
     * @return				The image resulting from the combination of the sources
     */
    @Override
    public Image doVerticalStripes(Image src1, Image src2, int stripeWidth) {
    	WritableImage striped = new WritableImage(300, 300);
    	PixelReader pr1 = src1.getPixelReader();
    	PixelReader pr2 = src2.getPixelReader();
    	PixelWriter pw = striped.getPixelWriter();
    	for(int x = 0; x < 300; x++){
    		for(int y = 0; y < 300; y++){
    			if (x == 0 || (x / stripeWidth) % 2 == 1){
    				pw.setColor(x, y, pr1.getColor(x, y));
    			}
    			else if ((x / stripeWidth) % 2 == 0) {
    				pw.setColor(x, y, pr2.getColor(x, y));
    			}
    		}
    	}
    	System.out.println("VERTICAL STRIPE");
    	return striped;
    } // doVerticalStripes

} // MyArtsy




