package com.examly.springdemo.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;
import java.util.UUID;

public class ImageUtils {

    public static String saveBase64Image(String base64Image, String uploadDir) throws IOException {
        // Remove "data:image/jpeg;base64," prefix if present
        if (base64Image.contains(",")) {
            base64Image = base64Image.split(",")[1];
        }

        byte[] imageBytes = Base64.getDecoder().decode(base64Image);
        String fileName = UUID.randomUUID() + ".jpg";
        String filePath = uploadDir + "/" + fileName;

        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            fos.write(imageBytes);
        }
        return fileName;
    }

    public static String encodeImageToBase64(File file) throws IOException {
        String extension = "jpeg"; // default
        String fileName = file.getName().toLowerCase();

        if (fileName.endsWith(".png"))
            extension = "png";
        else if (fileName.endsWith(".jpg"))
            extension = "jpg";
        else if (fileName.endsWith(".jpeg"))
            extension = "jpeg";

        byte[] imageBytes = Files.readAllBytes(file.toPath());
        String base64 = Base64.getEncoder().encodeToString(imageBytes);
        return "data:image/" + extension + ";base64," + base64;
    }

}
