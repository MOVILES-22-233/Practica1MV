package com.example.pcengine;

import com.example.engine.Font;
import com.example.engine.Image;

import java.awt.Color;
import java.awt.geom.AffineTransform;

import javax.swing.JFrame;

public class Graphics implements com.example.engine.Graphics {
    private JFrame win;
    private AffineTransform afineTransform;
    private java.awt.Graphics graphics;
    private Engine engine;

    public Graphics(JFrame win_, Engine engine_)
    {
        super();
        win = win_;
        engine = engine_;
    }

    @Override
    public Image newImage() {
        return null;
    }

    @Override
    public Font newFont() {
        return null;
    }

    @Override
    public void setResolution(int width, int height) {
        win.setSize(width, height);
    }

    @Override
    public void setColour(int r, int g, int b) {
        graphics.setColor(new Color(r,g,b));
    }

    @Override
    public void setFont(Font font) {
        //graphics.setFont((Font)font).getFont());
    }

    @Override
    public void drawImage(Image image, int x, int y) {

    }

    @Override
    public void drawRectangle(int x, int y, int width, int height) {
        graphics.drawRect(x, y, width, height);
    }

    @Override
    public void fillRectangle(int x, int y, int width, int height) {
        graphics.fillRect(x, y, width, height);
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
        graphics.drawLine(x1, y1, x2, y2);
    }

    @Override
    public void drawText(String text, int x, int y) {
        graphics.drawString(text, x, y);
    }
}
