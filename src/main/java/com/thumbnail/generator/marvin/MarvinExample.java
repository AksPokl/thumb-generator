package com.thumbnail.generator.marvin;

import marvin.image.MarvinImage;
import org.marvinproject.image.transform.scale.Scale;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

// четкий как и core
// GNU Lesser General Public License (LGPL).
public class MarvinExample {

    public static void main(String[] args) throws IOException {
        BufferedImage originalImage = ImageIO.read(new File("src/main/resources/125474.jpg"));
        BufferedImage outputImage = resizeImage(originalImage, 250, 250);
        ImageIO.write(outputImage, "jpg", new File("src/main/resources/sampleImage-resized-marvin.jpg"));
    }

    private static BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) {
        MarvinImage image = new MarvinImage(originalImage);
        Scale scale = new Scale();
        scale.load();
        scale.setAttribute("newWidth", targetWidth);
        scale.setAttribute("newHeight", targetHeight);
        scale.process(image.clone(), image, null, null, false);
        return image.getBufferedImageNoAlpha();
    }
}
