package com.example.nonograma;

import com.example.engine.Engine;
import com.example.engine.Graphics;

public class Cell {
    private  int x, y;
    private int side;
    private int value;

    private Engine.Color currentColor;

    public Cell(int posX, int posY, int side_, Engine.Color color) {
        x = posX;
        y = posY;
        side = side_;
        currentColor = color;
        value = 0;
    }

    public void render(Graphics graphics) {
        graphics.setColor(currentColor);
        graphics.drawSquare(x, y, side);
    }

    public void changeColor(Engine.Color color) {
        currentColor = color;
    }

    public Engine.Color getCurrentColor() { return currentColor; }

    public int getX() { return x; }

    public int getY() { return y; }

    public int getValue() { return value; }

    public void setValue(int value) {
        this.value = value;
    }
}
