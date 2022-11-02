package com.example.nonograma;

public abstract interface Caller {
    public abstract boolean inBounds(float x, float y);
    public abstract void handleInput();
}
