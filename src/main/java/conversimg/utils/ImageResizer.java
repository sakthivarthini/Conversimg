/*
 *************************************************
 ** Conversimg - An image converter and resizer **
 ** Author: Ruben Rodriguez Esteban **************
 ** Date: 13-12-2019 *****************************
 *************************************************
 */


package conversimg.utils;

import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.twelvemonkeys.image.ResampleOp;

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
	 
	    BufferedImageOp resampler = new ResampleOp(scaledWidth, scaledHeight, ResampleOp.FILTER_LANCZOS);
	    BufferedImage output = resampler.filter(input, null);
		 
	    // extracts extension of output file
	 	String formatName = outputImage.substring(outputImage.lastIndexOf(".") + 1);
	 	
		// writes to output file
		ImageIO.write(output, formatName, new File(outputImage));
		System.out.println("The image has been resized succesfully");
	}
	 
}
