package com.example.engine;

public interface Engine {
    Graphics getGraphics();
    Audio getAudio();
    State getState();
    Input getInput();

    public class Vector2 {
        public int x, y;

        public Vector2(int x_, int y_) {
            x = x_;
            y = y_;
        }
    }

    public class Color {
        public int r, g, b;

        public Color(int r_, int g_, int b_) {
            r = r_;
            g = g_;
            b = b_;
        }
    }
}
