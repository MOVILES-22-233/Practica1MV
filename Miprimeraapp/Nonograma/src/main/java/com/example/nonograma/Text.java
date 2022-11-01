package com.example.nonograma;

import com.example.engine.Engine;
import com.example.engine.Font;
import com.example.engine.Graphics;

public class Text extends GameObject {
    private String text;
    private Font font;

    public Text (int x, int y, String text, Font font) {
        super(x, y, 0, 0);
        this.text = text;
        this.font = font;
    }

    @Override
    public void update(double deltaTime) { }

    @Override
    public void render(Graphics graphics) {
        graphics.setFont(font);
        graphics.setColor(new Engine.Color(0, 0, 0));
        graphics.drawText(this.text, this.getX(), this.getY());
    }
}
