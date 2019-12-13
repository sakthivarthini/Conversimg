/*
 *************************************************
 ** Conversimg - An image converter and resizer **
 ** Author: Ruben Rodriguez Esteban **************
 ** Date: 13-12-2019 *****************************
 *************************************************
 */


package conversimg.utils;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageResizer {
	
	/**
	 * Resizes an image to a absolute width and height (the image may not be
	 * proportional)
	 * @param inputImagePath Path of the original image
	 * @param outputImagePath Path to save the resized image
	 * @param scaledWidth absolute width in pixels
	 * @param scaledHeight absolute height in pixels
	 * @throws IOException
	 */
	public static void resize(String inputImage, String outputImage, int scaledWidth, int scaledHeight) throws IOException {
		// reads input image
		File inputFile = new File(inputImage);
		BufferedImage input = ImageIO.read(inputFile);
	 
		// creates output image
		BufferedImage output = new BufferedImage(scaledWidth, scaledHeight, input.getType());
		    
		// scales the input image to the output image
		Graphics2D g2d = output.createGraphics();
		g2d.drawImage(input, 0, 0, scaledWidth, scaledHeight, null);
		g2d.dispose();
					 
		// extracts extension of output file
		String formatName = outputImage.substring(outputImage.lastIndexOf(".") + 1);
		 
		// writes to output file
		ImageIO.write(output, formatName, new File(outputImage));
		System.out.println("The image has been resized succesfully");
	}
	 
}
