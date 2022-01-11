package com.thumbnail.generator.core;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

// самый быстрый
public class Graphics2DExample {

    public static void main(String[] args) throws IOException {
        BufferedImage originalImage = ImageIO.read(new File("src/main/resources/125474.jpg"));
        BufferedImage outputImage = resizeImage(originalImage, 250, 250);
        ImageIO.write(outputImage, "jpg", new File("src/main/resources/sampleImage-resized-graphics2d.jpg"));
    }

    private static BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) {
        BufferedImage resizedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = resizedImage.createGraphics();
        graphics2D.drawImage(originalImage, 0, 0, targetWidth, targetHeight, null);
        graphics2D.dispose();
        return resizedImage;
    }
}
