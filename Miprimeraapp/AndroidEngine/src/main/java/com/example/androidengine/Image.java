package com.example.androidengine;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Image implements com.example.engine.Image {
    private Bitmap image;

    public Image(String filename) {
        super();
        try {
            image = BitmapFactory.decodeStream(new FileInputStream(filename));
        }
        catch (Exception e) {
            System.err.println("Couldn't load file " + filename);
            e.printStackTrace();
        }
    }

    public Bitmap getImage() {
        return  image;
    }

    @Override
    public int getWidth() {
        return image.getWidth();
    }

    @Override
    public int getHeight() {
        return image.getHeight();
    }
}
