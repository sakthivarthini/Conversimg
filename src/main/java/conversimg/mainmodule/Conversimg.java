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
import java.net.MalformedURLException;

import javax.imageio.ImageIO;

import com.itextpdf.text.DocumentException;

import conversimg.utils.ImageConverter;
import conversimg.utils.ImageResizer;
import conversimg.utils.PdfCreator;



public class Conversimg {
	
	// Number of parameters of the program
	private static int PARAMETERS_CONVERSION = 3;
	private static int PARAMETERS_RESIZE = 4;
	private static int PARAMETERS_PDF = 3;


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
					// Check if the format is the same 
					if (!inputExtension.equals(formatName)){
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
					else {
						System.out.println("The format of input and output is the same");
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
	 * Obtains a pdf file given an image file
	 * @param inputImagePath Path of the original image
	 * @param outputImagePath Path to save the pdf file
	 * @throws DocumentException 
	 * @throws MalformedURLException 
	 * @throws IOException
	 */
	public static void convertImageToPdfFile(String inputImagePath, String outputImagePath) throws MalformedURLException, 
																								   IOException, DocumentException 
	{
		// Conversion of the image to pdf file
		PdfCreator.convertImageToPdf(inputImagePath, outputImagePath);
	}



	/**
	 * Obtains a pdf file given an image file
	 * @param inputImagePath Path of the original pdf
	 * @param outputImagePath Path to save the image
	 * @throws DocumentException 
	 * @throws MalformedURLException 
	 * @throws IOException
	 */
	public static void convertPdfToImage(String inputImagePath, String outputImagePath) throws MalformedURLException, 
																							   IOException, DocumentException 
	{
		// Conversion of the pdf to a image file
		PdfCreator.convertPdfToImage(inputImagePath, outputImagePath);
	}
	


	/**
	 * Application that allows the user to resize or change the format of 
	 * the images that the user wants.
	 * 
	 * @param argc is the nunber of parameters of the application
	 * @param args is the vector of parameters of the application
	 * @throws NumberFormatException, IOException
	 * @throws DocumentException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException, DocumentException {
		// Shows in terminal how to invoke the program if the parameters are wrong
		if (args.length != PARAMETERS_CONVERSION && args.length != PARAMETERS_RESIZE && args.length != PARAMETERS_PDF) {
			// Wrong number of parameters introduced
			showMenu();
		}
		else {
			// The number of parameters is correct
			// Check if the execution flag is correct
			if (args[0].equals("-c")) {
				// Check if the number of arguments is correct
				if (args.length != PARAMETERS_CONVERSION) {
					System.out.println("Wrong amount of parameters for convert an image");
				}
				else {
					// Conversion of the image
					String format = args[2].substring(args[2].lastIndexOf(".") + 1);
					convertImage(args[1], args[2], format);
				}
				
			}
			else if (args[0].equals("-r")) {
				// Check if the number of arguments is correct
				if (args.length != PARAMETERS_RESIZE) {
					System.out.println("Wrong amount of parameters for resize an image");
				}
				else {
					// Resize of the image
					resizeImage(args[1], args[2], Double.parseDouble(args[3]));
				}
			}
			else if (args[0].equals("-ip")) {
				// Check if the number of arguments is correct
				// Check if the number of arguments is correct
				if (args.length != PARAMETERS_PDF) {
					System.out.println("Wrong amount of parameters for convert from image to pdf");
				}
				else {
					// Conversion from image to pdf
					convertImageToPdfFile(args[1], args[2]);
				}
			}
			else if (args[0].equals("-pi")) {
				// Check if the number of arguments is correct
				if (args.length != PARAMETERS_PDF) {
					System.out.println("Wrong amount of parameters for convert from pdf to image");
				}
				else {
					// Conversion from pdf to image
					PdfCreator.convertPdfToImage(args[1], args[2]);
				}
				
			}
			else {
				// Incorrect flag introduced
				System.out.println("Flag option choosen is not contempled");
			}
		}
		System.out.println("Final execution programm");
	}
}
