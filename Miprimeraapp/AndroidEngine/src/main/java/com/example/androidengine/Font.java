package com.example.androidengine;

import android.graphics.Typeface;

public class Font implements com.example.engine.Font {
    private int size;
    private boolean bold;
    private Typeface font;

    public Font(String filename, int size_, boolean bold_) {
        super();
        try {
            font = Typeface.createFromFile(filename);
            size = size_;
            bold = bold_;
        }
        catch (Exception e) {
            System.err.println("Couldn't open file " + filename);
            e.printStackTrace();
        }
    }

    public Typeface getFont() {
        return font;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isBold() {
        return bold;
    }
}
