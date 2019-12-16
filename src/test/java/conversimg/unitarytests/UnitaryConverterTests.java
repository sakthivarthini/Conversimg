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
import org.junit.Test;
import conversimg.mainmodule.Conversimg;

public class UnitaryConverterTests {
	
	
	// Format image vector
	String[] supportedFormats = new String[] {"jpg","png","bmp", "gif"};
	

    @Test
    public void testConversionImage() {

        // Variables with the image in different formats
        String inputImage;
        String outputImage;
        String format;

        // Choose an input image with each supported format
        for (int i = 0; i < supportedFormats.length; i++) {
            // Generate the input image
            inputImage = "Images/prueba." + supportedFormats[i];

            // Create an ooutput image with a different format
            for (int j = 0; j < supportedFormats.length; j++) {

                // Verify if input and output formats are equal
                if (!supportedFormats[i].equals(supportedFormats[j])) {
                    // Generate the output image
                    outputImage = "Images/pruebaSalida." + supportedFormats[j];

                    // Generate the output image
                    format = supportedFormats[j];

                    // Conversion of the image to the specified format
                    Conversimg.convertImage(inputImage, outputImage, format);

                    // Determine if the file has been generated correctly in the parameter path
                    final File tmpDir = new File(outputImage);
                    final boolean exists = tmpDir.exists();

                    assertEquals(exists, true);

                }
            }
            // Clean the last value images for the next conversion
            inputImage = "";
            outputImage = "";
            format = "";
        }
    }

}
