package com.thumbnail.generator.core;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

// самый четкий
public class ImageScaledInstanceExample {

    public static void main(String[] args) throws IOException {
        BufferedImage originalImage = ImageIO.read(new File("src/main/resources/125474.jpg"));
        BufferedImage outputImage = resizeImage(originalImage, 250, 250);
        ImageIO.write(outputImage, "jpg", new File("src/main/resources/sampleImage-resized-scaledinstance.jpg"));
    }

    private static BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) {
        Image resultingImage = originalImage.getScaledInstance(targetWidth, targetHeight, Image.SCALE_DEFAULT);
        BufferedImage bufferedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
        bufferedImage.getGraphics()
                .drawImage(resultingImage, 0, 0, null);
        return bufferedImage;
    }
}
