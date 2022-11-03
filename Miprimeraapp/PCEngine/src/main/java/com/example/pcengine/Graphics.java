package com.example.pcengine;

import com.example.engine.Font;
import com.example.engine.Image;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import javax.swing.JFrame;

public class Graphics implements com.example.engine.Graphics {
    private JFrame win;
    private AffineTransform affineTransform;
    private java.awt.Graphics graphics;
    private Engine engine;

    public Graphics(JFrame win_, Engine engine_) {
        super();
        win = win_;
        engine = engine_;
    }

    @Override
    public Image newImage(String filename) {
        return new com.example.pcengine.Image(filename);
    }

    @Override
    public Font newFont(String filename, int size, boolean bold) {
        return new com.example.pcengine.Font(filename, size, bold);
    }

    @Override
    public void setResolution(int width, int height) {
        win.setSize(width, height);
    }

    @Override
    public void setColor(com.example.engine.Engine.Color color) {
        graphics.setColor(new Color(color.r, color.g, color.b));
    }

    @Override
    public void setFont(Font font) {
        java.awt.Font font_ = ((com.example.pcengine.Font)font).getFont();
        graphics.setFont(font_);
    }

    public void setGraphics(java.awt.Graphics graphics_) {
        graphics = graphics_;
    }

    @Override
    public void drawImage(Image image, int x, int y) {
        graphics.drawImage(((com.example.pcengine.Image)image).getImage(), x, y, null);
    }

    @Override
    public void drawSquare(int cx, int cy, int side) {
        graphics.drawRect(cx, cy, cx + side, cy + side);
    }

    @Override
    public void fillSquare(int cx, int cy, int side) {
        graphics.fillRect(cx, cy, cx + side, cy + side);
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

    @Override
    public void clear(com.example.engine.Engine.Color color) {
        graphics.setColor(new Color(color.r, color.g, color.b));
        graphics.fillRect(0, 0, win.getWidth(), win.getHeight());
    }

    @Override
    public void translate(int x, int y) {
        graphics.translate(x, y);
    }

    @Override
    public void scale(int x, int y) {
        ((Graphics2D)graphics).scale(x, y);
    }

    @Override
    public void save() {
        affineTransform = ((Graphics2D)graphics).getTransform();
    }

    @Override
    public void restore() {
        ((Graphics2D)graphics).setTransform(affineTransform);
    }

    @Override
    public com.example.engine.Engine.Vector2 adjustToWindow() {
        translate(getWidth() / 2, getHeight() / 2);

        float incX = (float)getWidth() / engine.getWidth();
        float incY = (float)getHeight() / engine.getHeight();

        if (engine.getWidth() * incY < getWidth()) {
            scale((int)incY, (int)-incY);
        }
        else scale((int)incX, (int)-incX);

        return new com.example.engine.Engine.Vector2(getWidth(), getHeight());
    }

    public int getWidth() {
        return win.getWidth();
    }

    public int getHeight() {
        return win.getHeight();
    }
}
