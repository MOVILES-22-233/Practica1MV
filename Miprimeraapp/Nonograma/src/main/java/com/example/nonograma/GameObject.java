package com.example.nonograma;

import com.example.engine.Engine;
import com.example.engine.Graphics;

public abstract class GameObject {
    private int x, y, w, h;
    private Engine.Color color;
    private boolean hasInput;

    public GameObject(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public abstract void update(double deltaTime);

    public abstract void render(Graphics graphics);

    public int getX() { return this.x; }
    public int getY() { return this.y; }
    public int getW() { return this.w; }
    public int getH() { return this.h; }
}
