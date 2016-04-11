package main.java.cs1302.p2;

import main.java.cs1302.effects.Artsy;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;

public class MyArtsy implements Artsy {

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
    			else if((x / checkSize) % 2 == 0 && (y / checkSize) % 2 == 0){
    				pw.setColor(x, y, pr1.getColor(x, y));
    			}
    			else if((x / checkSize) % 2 == 1 && (y / checkSize) % 2 == 1){
    				pw.setColor(x, y, pr2.getColor(x, y));
    			}
    		}
    	}
    	System.out.println("CHECKER")
    	return checked;
    } // doCheckers

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

    @Override
    public Image doRotate(Image src, double degrees) {
    	double rads = Math.toRadians(degrees);
    	int width = (int) src.getWidth();
    	int height = (int) src.getHeight();
    	WritableImage rotated = new WritableImage(width, height);
    	PixelReader pr = src.getPixelReader();
    	PixelWriter pw = rotated.getPixelWriter();
    	for(int x = 0; x < width; x++){
    		for(int y = 0; y < height; y++){
    			int newX = (int) (((x - (width / 2))  * Math.cos(rads)) - ((y - (height / 2)) * Math.sin(rads)));
    			int newY = (int) (((x - (width / 2)) * Math.sin(rads)) + ((y - (height /2)) * Math.cos(rads)));
    			
    			pw.setColor((newX + (width * 2)), (newY + (height * 2)), pr.getColor(x, y));
  
    		}
    	}
    	System.out.println("ROTATE");
    	return rotated;
    } // doRotate

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



