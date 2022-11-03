package com.example.engine;

public interface Graphics {
    Image newImage(String filename);
    Font newFont(String filename, int size, boolean bold);

    void setResolution(int width, int height);
    void setColor(Engine.Color color);
    void setFont(Font font);

    void drawImage(Image image, int x, int y);
    void drawSquare(int cx, int cy, int side);
    void fillSquare(int cx, int cy, int side);
    void drawRectangle(int x, int y, int width, int height);
    void fillRectangle(int x, int y, int width, int height);
    void drawLine(int x1, int y1, int x2, int y2);
    void drawText(String text, int x, int y);

    void clear(Engine.Color color);

    // Metodos de control de transformacion sobre el canvas
    void translate(int x, int y);
    void scale(int x, int y);
    void save();
    void restore();

    Engine.Vector2 adjustToWindow();
}
