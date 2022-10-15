package com.example.pcengine;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Image implements com.example.engine.Image {
    private BufferedImage image;

    public Image(String filename) {
        super();
        try {
            image = ImageIO.read(new File(filename));
        }
        catch (Exception e) {
            System.err.println("Couldn't open file " + filename);
            e.printStackTrace();
        }
    }

    @Override
    public int getWidth() {
        return image.getWidth();
    }

    @Override
    public int getHeight() {
        return image.getHeight();
    }

    public BufferedImage getImage() { return image; }
}
