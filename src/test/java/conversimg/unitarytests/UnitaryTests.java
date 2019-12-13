package conversimg.unitarytests;

import static org.junit.Assert.*;
import java.io.File;
import java.io.IOException;
import org.junit.Test;

import conversimg.mainmodule.Conversimg;

public class UnitaryTests {
	
	
	// Format image vector
	String[] supportedFormats = new String[] {"jpg","png","bmp", "gif"};
	
	// Scale image vector
	double[] exampleScales = new double[] {0.5, 1,5};
	
	// Identifier image scale
	String[] identifierScales = new String[] {"XXS.","XS.","XL.", "XXL."};


	
	@Test
	public void testValidImageJPGFormat() {
		// Fictional image file
		final String image = "Images/prueba.jpg";
        // extracts extension of the image converted or the image which is going to be
        // converted
        final String formatName = image.substring(image.lastIndexOf(".") + 1);
        // Determines if the format of the image is supported
        assertEquals("jpg", formatName);
    }

    @Test
    public void testValidImagePNGFormat() {
        // Fictional image file
        final String image = "Images/prueba.png";
        // extracts extension of the image converted or the image which is going to be
        // converted
        final String formatName = image.substring(image.lastIndexOf(".") + 1);
        // Determines if the format of the image is supported
        assertEquals("png", formatName);
    }

    @Test
    public void testValidImageBMPFormat() {
        // Fictional image file
        final String image = "Images/prueba.bmp";
        // extracts extension of the image converted or the image which is going to be
        // converted
        final String formatName = image.substring(image.lastIndexOf(".") + 1);
        // Determines if the format of the image is supported
        assertEquals("bmp", formatName);
    }

    @Test
    public void testValidImageGIFFormat() {
        // Fictional image file
        final String image = "Imagenes/prueba.gif";
        // extracts extension of the image converted or the image which is going to be
        // converted
        final String formatName = image.substring(image.lastIndexOf(".") + 1);
        // Determines if the format of the image is supported
        assertEquals("gif", formatName);
    }

    @Test
    public void testConversionImageTrue() {

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
                    outputImage = "Images\\pruebaSalida." + supportedFormats[j];

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

    @Test
    public void testResizeImageTrue() throws IOException {
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
							
						// Delete the image generated for the test
						// tmpDir.delete();		
					}
					// Clean the last value images for the next conversion
					inputImage = "";
					outputImage = "";
				}
	}
	
	
	
}
