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


import conversimg.mainmodule.Conversimg;

public class UnitaryResizeTests {


    // Format image vector
    String[] supportedFormats = new String[] {"jpg","png","bmp", "gif"};

    // Scale image vector
    double[] exampleScales = new double[] {0.5, 1,5};
        
    // Identifier image scale
    String[] identifierScales = new String[] {"XXS.","XS.","XL.", "XXL."};


    @Test
    public void testResizeImage() throws IOException {
        // Variables with the image in different formats
        String inputImage;
        String outputImage;

        // Choose an input image with each supported format
        for (int i = 0; i < supportedFormats.length; i++) {
            // Generate the input image
            inputImage = "Images/prueba." + supportedFormats[i];

            // Create an ooutput image with a different format
            for (int j = 0; j < exampleScales.length; j++) {

                // Generate the output image
                outputImage = "Images/pruebaSalida" + identifierScales[j] + supportedFormats[i];

                System.out.println(outputImage);

                // Conversion of the image to the specified format
                Conversimg.resizeImage(inputImage, outputImage, exampleScales[j]);

                // Determine if the file has been generated correctly in the parameter path
                final File tmpDir = new File(outputImage);
                final boolean exists = tmpDir.exists();
                            
                        assertEquals(exists, true);
                            
                    }
                    // Clean the last value images for the next conversion
                    inputImage = "";
                    outputImage = "";
                }
    }

}
