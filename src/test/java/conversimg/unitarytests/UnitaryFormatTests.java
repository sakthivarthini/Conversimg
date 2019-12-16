package conversimg.unitarytests;

import static org.junit.Assert.*;
import org.junit.Test;


public class UnitaryFormatTests {

	
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

}