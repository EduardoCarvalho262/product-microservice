package com.gft.product.util;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

@SpringBootTest
public class UtilTests {

    @Test
    public void givenAImagePath_whenUseMethod_thenReturnAStringBase64() throws IOException, URISyntaxException {
        // Arrange
        URL resourceUrl = ClassLoader.getSystemResource("assets/imageTest.jpg");
        if (resourceUrl == null) {
            throw new FileNotFoundException("File not found: assets/imageTest.jpg");
        }
        Path imagePath = Paths.get(resourceUrl.toURI());

        // Act
        String base64 = ImageToBase64Converter.convertImageToBase64(imagePath);

        // Asserts
        Assert.assertNotNull(base64);
        Assert.assertFalse(base64.isEmpty());
    }
}
