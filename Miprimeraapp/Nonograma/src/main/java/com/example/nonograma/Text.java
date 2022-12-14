package com.example.nonograma;

import com.example.engine.Engine;
import com.example.engine.Font;
import com.example.engine.Graphics;

public class Text extends GameObject implements Caller {
    private String text;
    private String function;
    private Font font;

    public Text (int x, int y, String text, Font font, String function) {
        super(x, y, text.length() * font.getSize() - text.length() * 2, font.getSize() + font.getSize() / 2);
        this.text = text;
        this.function = function;
        this.font = font;
    }

    @Override
    public void update(double deltaTime) { }

    @Override
    public void render(Graphics graphics) {
        //graphics.drawRectangle(getX(), getY() - getH(), getW(), getH());
        graphics.setFont(font);
        graphics.setColor(new Engine.Color(0, 0, 0));
        graphics.drawText(this.text, this.getX(), this.getY());
    }

    @Override
    public void handleInput() {
        
    }

    @Override
    public boolean inBounds(float x, float y) {
        if ((x >= getX() && x <= getW()) && (y >= getY() && y <= getH()))
            return true;
        return false;
    }

    @Override
    public String getFunction() {
        return this.function;
    }
}
