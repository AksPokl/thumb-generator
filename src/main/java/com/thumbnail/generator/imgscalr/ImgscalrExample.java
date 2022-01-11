package com.thumbnail.generator.imgscalr;

import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

// под капотом Graphic2D, Graphic2D быстрее
// есть режимы AUTOMATIC, FIT_EXACT
// режимы качества AUTOMATIC, BALANCED, QUALITY, SPEED, ULTRA_QUALITY
// по сравнению с core - качество не самое лучшее, не смотря даже на режимы
// есть apache-2.0 лицензия
public class ImgscalrExample {

    public static void main(String[] args) throws Exception {
        BufferedImage originalImage = ImageIO.read(new File("src/main/resources/125474.jpg"));
        BufferedImage outputImage = resizeImage(originalImage, 250, 250);
        ImageIO.write(outputImage, "jpg", new File("src/main/resources/sampleImage-resized-imgscalr.jpg"));
    }

    private static BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) {
        return Scalr.resize(originalImage, Scalr.Method.BALANCED, Scalr.Mode.FIT_EXACT, targetWidth, targetHeight, Scalr.OP_ANTIALIAS);
    }
}
