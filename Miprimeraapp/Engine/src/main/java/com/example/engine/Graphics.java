package com.example.engine;

public interface Graphics {
    Image newImage();
    Font newFont();

    void setResolution(int width, int height);
    void setColour(int r, int g, int b);
    void setFont(Font font);

    void drawImage(Image image, int x, int y);
    void drawRectangle(int x, int y, int width, int height);
    void fillRectangle(int x, int y, int width, int height);
    void drawLine(int x1, int y1, int x2, int y2);
    void drawText(String text, int x, int y);
}
