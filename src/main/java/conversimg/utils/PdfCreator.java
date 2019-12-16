/*
 *************************************************
 ** Conversimg - An image converter and resizer **
 ** Author: Ruben Rodriguez Esteban **************
 ** Date: 13-12-2019 *****************************
 *************************************************
 */


package conversimg.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.tools.imageio.ImageIOUtil;

import java.awt.image.BufferedImage;
import java.io.File;

public class PdfCreator {
	
	/**
	 * Checks if the file is a pdf or not
	 * @param file
	 * @return <<true>> if the file is a pdf,
	 * 		   Otherwise returns <<false>>.
	 */
	public static boolean isPdfFile(String file) {
		return file.substring(file.lastIndexOf(".") + 1).equals("pdf");
	}

	

	/**
	 * Converts the image into a pdf file
	 * @param inputImage is the image which is going to be converted to pdf
	 * @param outputFile is path of the resultant pdf
	 * @throws MalformedURLException
	 * @throws IOException
	 * @throws DocumentException
	 */
	public static void convertImageToPdf(String inputImage, String outputFile) throws MalformedURLException, 
																	IOException, DocumentException
	{
		// Check if the destination file is a pdf
		if (isPdfFile(outputFile)) {	
			// Creation of the document with their dimension 
			// YO CAN CHANGE THE DIMENSIONS IF YOU WANT
			Document document = new Document(PageSize.A4, 20, 20, 20, 20);					
			PdfWriter.getInstance(document, new FileOutputStream(new File(outputFile)));
			// Preparing the document
			document.open();
			document.newPage();
			// Read the image
			Image image = Image.getInstance(new File(inputImage).getAbsolutePath());
			// Insert the image in the pdf document
			image.setAbsolutePosition(0, 0);
			image.setBorderWidth(0);
			image.scaleAbsoluteHeight(PageSize.A4.getHeight());
			image.scaleAbsoluteWidth(PageSize.A4.getWidth());
			// Add the image an close the document
			document.add(image);
			document.close();
		}
		else {
			// Error because the destination file is not a pdf
			System.out.println("The destination file must be a pdf");
		}
	}
	
	
	
	/**
	 * Converts a pdf file to a image with a determined extension
	 * Supports JPG jpg bmp BMP gif GIF WBMP iff IFF png PNG JPEG wbmp jpeg
	 * @param sourceDir is the pdf file
	 * @param destinationDir is the image 
	 * @throws IOException
	 */
	public static void convertPdfToImage(String sourceDir, String destinationDir) throws IOException {
		// Check if the file is a pdf
		if (isPdfFile(sourceDir)) {
			// Load the pdf document and gets all the pages
			PDDocument document = PDDocument.load(new File(sourceDir));
			PDFRenderer pdfRenderer = new PDFRenderer(document);
			// For each page extracts the images
			for (int page = 0; page < document.getNumberOfPages(); ++page){
				BufferedImage bim = pdfRenderer.renderImageWithDPI(page, 300, ImageType.RGB);				
				ImageIOUtil.writeImage(bim, destinationDir, 300);
			}
			// Close the document
			document.close();
		}
		else {
			// The file is not a pdf 
			System.out.println("The origin file introduced is not a pdf");
		}
		
	}
}
