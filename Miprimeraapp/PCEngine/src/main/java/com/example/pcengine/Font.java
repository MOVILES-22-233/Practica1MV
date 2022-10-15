package com.example.pcengine;

import java.io.File;

public class Font implements com.example.engine.Font {
    private int size;
    private boolean bold;
    private java.awt.Font font = null;

    public Font(String filename, int size_, boolean bold_) {
        super();
        size = size_;
        bold = bold_;
        try {
            font = java.awt.Font.createFont(java.awt.Font.TRUETYPE_FONT, new File(filename));
            if (bold)
                font = font.deriveFont(java.awt.Font.BOLD, size);
            else
                font = font.deriveFont(java.awt.Font.PLAIN, size);
        }
        catch (Exception e) {
            System.err.println("Couldn't find file " + filename);
            e.printStackTrace();
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isBold() {
        return bold;
    }

    public java.awt.Font getFont() {
        return font;
    }
}
