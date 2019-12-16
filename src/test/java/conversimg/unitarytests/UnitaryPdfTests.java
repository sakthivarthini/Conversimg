/*
 *************************************************
 ** Conversimg - An image converter and resizer **
 ** Author: Ruben Rodriguez Esteban **************
 ** Date: 13-12-2019 *****************************
 *************************************************
 */

package conversimg.unitarytests;


import static org.junit.Assert.*;
import java.io.File;
import java.io.IOException;
import org.junit.Test;
import java.net.MalformedURLException;
import com.itextpdf.text.DocumentException;


import conversimg.mainmodule.Conversimg;


public class UnitaryPdfTests {

    // Format image vector
    String[] supportedFormats = new String[] {"jpg","png","bmp", "gif"};


    @Test
    public void testsConversionImageToPdf() throws MalformedURLException, IOException, DocumentException {

        // Variables with the image in different formats
        String inputImage;
        String outputFile;

        // Choose an input image with each supported format
        for (int i = 0; i < supportedFormats.length; i++) {
        	
            // Generate the input image
            inputImage = "Images/prueba." + supportedFormats[i];
            
        	System.out.println("inputImage");

            // Generate the output image
            outputFile = "Pdfs/pruebaSalida_" + i + ".pdf";

            System.out.println("outputFile");
            	
             // Conversion of the image to the specified format
             Conversimg.convertImageToPdfFile(inputImage, outputFile);
                
             // Determine if the file has been generated correctly in the parameter path
             final File tmpDir = new File(outputFile);
             final boolean exists = tmpDir.exists();

             assertEquals(exists, true);
             
             // Clean the last value images for the next conversion
             inputImage = "";
             outputFile = "";
        }
    }



    @Test
    public void testsConversionPdfToImage() throws MalformedURLException, IOException, DocumentException {

        // Variables with the image in different formats
        String inputImage;
        String outputFile;

        // Generate the input pdf
        inputImage = "Pdfs/prueba.pdf";

        // Choose an input image with each supported format
        for (int i = 0; i < supportedFormats.length; i++) {

            // Generate the output image
            outputFile = "Images/imagenDePdf." + supportedFormats[i];
            	
            // Conversion of the image to the specified format
            Conversimg.convertPdfToImage(inputImage, outputFile);
                
            // Determine if the file has been generated correctly in the parameter path
            final File tmpDir = new File(outputFile);
            final boolean exists = tmpDir.exists();

            assertEquals(exists, true);
             
            // Clean the last value images for the next conversion
            outputFile = "";
        }
    }
}