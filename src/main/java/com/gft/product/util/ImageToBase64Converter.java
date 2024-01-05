package com.gft.product.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;

public class ImageToBase64Converter {
    public static String convertImageToBase64(Path imagePath) throws IOException {
        byte[] imageBytes = Files.readAllBytes(imagePath);
        return Base64.getEncoder().encodeToString(imageBytes);
    }
}
