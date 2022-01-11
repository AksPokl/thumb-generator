package com.thumbnail.generator.thumbnailator;

import net.coobird.thumbnailator.Thumbnails;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

// сам подбирает размер, можно указать процент качества
// MIT License
// по сравнению с core - качество не самое лучшее, не смотря даже если outputQuality = 1.0
public class ThumbnailatorExample {

    public static void main(String[] args) throws Exception {
        BufferedImage originalImage = ImageIO.read(new File("src/main/resources/125474.jpg"));
        BufferedImage outputImage = resizeImage(originalImage, 250, 250);
        ImageIO.write(outputImage, "jpg", new File("src/main/resources/sampleImage-resized-thumbnailator.jpg"));
    }

    private static BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Thumbnails.of(originalImage)
                .size(targetWidth, targetHeight)
                .outputFormat("JPEG")
                .outputQuality(1.0)
                .toOutputStream(outputStream);
        byte[] data = outputStream.toByteArray();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
        return ImageIO.read(inputStream);
    }
}
