/*
 *************************************************
 ** Conversimg - An image converter and resizer **
 ** Author: Ruben Rodriguez Esteban **************
 ** Date: 13-12-2019 *****************************
 *************************************************
 */

package conversimg.utils;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;


public class ImageConverter {
	
	
	/**
     * Evaluates if the format of the image is supported or not
     *
     * @param imageFormat the format of the image (jpeg, png, bmp and gif
     * @return true if successful, false otherwise
     * @throws 
     */
	public static boolean isValidFormat(String imageFormat) {
		// Returns if the format of the image is correct
		return imageFormat.equals("jpg") || imageFormat.equals("png") || 
			   imageFormat.equals("bmp") || imageFormat.equals("gif") || imageFormat.equals("wbmp");
	
	}
	
	
	
	/**
     * Converts an image to another format
     *
     * @param inputImagePath Path of the source image
     * @param outputImagePath Path of the destination image
     * @param formatName the format to be converted to, one of: jpeg, png, bmp and gif
     * @return true if successful, false otherwise
     * @throws IOException if errors occur during writing
     */
	 public static boolean convertFormat(String inputImage, String outputImage, String format) throws IOException {
		
		boolean result;
		// Preparing to read and write the corresponding images
		FileInputStream inputStream = new FileInputStream(inputImage);
		FileOutputStream outputStream = new FileOutputStream(outputImage);
		 
		// Reads the input image file
		BufferedImage input = ImageIO.read(inputStream);
		 
		format = outputImage.substring(outputImage.lastIndexOf(".") + 1);
		
		// Writes the output image with the new format
		result = ImageIO.write(input, format, outputStream);
		// needs to close the streams
		outputStream.close();
		inputStream.close();
		
		// Returns if the image has been converter succesfully or not
		return result;
	 }
}
