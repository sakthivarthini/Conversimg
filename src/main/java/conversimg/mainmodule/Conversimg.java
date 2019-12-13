/*
 *************************************************
 ** Conversimg - An image converter and resizer **
 ** Author: Ruben Rodriguez Esteban **************
 ** Date: 13-12-2019 *****************************
 *************************************************
 */

package conversimg.mainmodule;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import conversimg.utils.ImageConverter;
import conversimg.utils.ImageResizer;;


public class Conversimg {
	
	// Number of parameters of the program
	private static int NUMBER_OF_PARAMETERS = 4;

	/**
	 * Presents the different options to run the application
	 */
	public static void showMenu() {
		System.out.println("Possible Invocation Options");
		System.out.println("<Conversing> <-c> <input_image_path> <output_image_path>");
		System.out.println("<Conversing> <-r> <input_image_path> <input_image_path> <percent>\n\n");
	}
	
	
	
	/**
     * Converts an image to another format
     *
     * @param inputImagePath Path of the source image
     * @param outputImagePath Path of the destination image
     * @param formatName the format to be converted to, one of: jpeg, png,
     * bmp and gif
     * @return true if successful, false otherwise
     */
	public static void convertImage(String inputImage, String oututImage, String formatName) {
		try {
			// extracts extension of input image file
			String inputExtension = inputImage.substring(inputImage.lastIndexOf(".") + 1);
			// Check if the formats of input is valid or not
			if (!ImageConverter.isValidFormat(inputExtension)) {
				// The image has not been converted well
				System.out.println("The origin image format is not supported");
			}
			else {
				// Check if the format of the output file are valid or not
				if (!ImageConverter.isValidFormat(formatName)) {
					// The image has not been converted well
					System.out.println("The destination image format is not supported");
				}
				else {
					// Attempt to convert the image
					boolean result = ImageConverter.convertFormat(inputImage, oututImage, formatName);
					if (result) {
						// The image gas been converted correctly
						System.out.println("Image converted successfully.");
						} 
					else {
						// The image has not been converted well
						System.out.println("Could not convert image.");
					}
				}
			}
		}
		catch (IOException ex) {
			// Exception produced during the conversion
			System.out.println("Error during converting image.");
			ex.printStackTrace();
		}
	}
	
	
	
	/**
	 * Resizes an image by a percentage of original size (proportional).
	 * @param inputImagePath Path of the original image
	 * @param outputImagePath Path to save the resized image
	 * @param percent a double number specifies percentage of the output image
	 * over the input image.
	 * @throws IOException
	 */
	public static void resizeImage(String inputImagePath, String outputImagePath, double percent) throws IOException {
		// File with the image which is going to be resized
		File inputFile = new File(inputImagePath);
		// Load the image from the file 
		BufferedImage inputImage = ImageIO.read(inputFile);
		// extracts extension of input image file
		String inputExtension = inputImagePath.substring(inputImagePath.lastIndexOf(".") + 1);
		// Check if the formats of input is valid or not
		if (!ImageConverter.isValidFormat(inputExtension)) {
			// The image has not been converted well
			System.out.println("The origin image format is not supported");
		}
		else {
			// extracts extension of output image file
			String outputExtension = outputImagePath.substring(outputImagePath.lastIndexOf(".") + 1);
			if (!ImageConverter.isValidFormat(outputExtension)) {
				// The image has not been converted well
				System.out.println("The origin image format is not supported");
			}
			else {
				if (!inputExtension.equals(outputExtension)) {
					// The format of input is different of output
					System.out.println("The formats of the images must be equal");
				}
				else {
					// Get new dimensions of the image
					int scaledWidth = (int) (inputImage.getWidth() * percent);
					int scaledHeight = (int) (inputImage.getHeight() * percent);
					// Resize the image with the specified dimensions
					ImageResizer.resize(inputImagePath, outputImagePath, scaledWidth, scaledHeight);
				}
				
			}
		}
	}
	
	
	
	/**
	 * Application that allows the user to resize or change the format of 
	 * the images that the user wants.
	 * 
	 * @param argc is the nunber of parameters of the application
	 * @param args is the vector of parameters of the application
	 * @throws NumberFormatException
	 * @throws NumberFormatException, IOException
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// Shows in terminal how to invoke the program if the parameters are wrong
		if (args.length != NUMBER_OF_PARAMETERS && args.length != NUMBER_OF_PARAMETERS - 1) {
			// Wrong number of parameters introduced
			showMenu();
		}
		else {
			// The number of parameters is correct
			// Check if the execution flag is correct
			if (args[0].equals("-c")) {
				// Conversion of the image
				String format = args[2].substring(args[2].lastIndexOf(".") + 1);
				convertImage(args[1], args[2], format);
			}
			else if (args[0].equals("-r")) {
				// Resize of the image
				resizeImage(args[1], args[2], Double.parseDouble(args[3]));
			}
			else {
				// Incorrect flag introduced
				System.out.println("Flag option choosen is not contempled");
			}
		}
		System.out.println("Final execution programm");
	}
}

