package com.example.androidengine;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import com.example.engine.Engine;
import com.example.engine.Font;
import com.example.engine.Image;

public class Graphics implements com.example.engine.Graphics {
    private com.example.androidengine.Engine engine;
    private Canvas canvas;
    private Paint paint;

    public Graphics(com.example.androidengine.Engine engine_) {
        super();
        paint = new Paint();
        canvas = new Canvas();
        engine = engine_;
    }

    @Override
    public Image newImage(String filename) {
        Image image = new com.example.androidengine.Image(filename);
        return image;
    }

    @Override
    public Font newFont(String filename, int size, boolean bold) {
        com.example.androidengine.Font font = new com.example.androidengine.Font(filename, size, bold);
        return font;
    }

    @Override
    public void setResolution(int width, int height) {
        // nose alv

    }

    public void setCanvas(Canvas canvas_) {
        canvas = canvas_;
    }

    @Override
    public void setColor(Engine.Color color) {
        paint.setColor(Color.rgb(color.r, color.g, color.b));
    }

    @Override
    public void setFont(Font font) {
        paint.setTypeface(((com.example.androidengine.Font)font).getFont());
        paint.setTextSize(font.getSize());
        paint.setFakeBoldText(font.isBold());
    }

    @Override
    public void drawImage(Image image, int x, int y) {
        Rect rect = new Rect(
                x - image.getWidth() / 2,
                y - image.getHeight() / 2,
                x + image.getWidth() / 2,
                y + image.getHeight() / 2
        );
        canvas.drawBitmap(
                ((com.example.androidengine.Image)image).getImage(),
                null,
                rect,
                paint
        );
    }

    @Override
    public void drawSquare(int cx, int cy, int side) {
        canvas.drawRect(cx, cy, cx + side, cy + side, paint);
    }

    @Override
    public void fillSquare(int cx, int cy, int side) {
        canvas.drawRect(cx, cy, cx + side, cy + side, paint);
    }

    @Override
    public void drawRectangle(int x, int y, int width, int height) {
        // BORRAR METODO
    }

    @Override
    public void fillRectangle(int x, int y, int width, int height) {
        // BORRAR METODO
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
        canvas.drawLine(x1, y1, x2, y2, paint);
    }

    @Override
    public void drawText(String text, int x, int y) {
        canvas.drawText(text, x, y, paint);
    }

    @Override
    public void clear(Engine.Color color) {
        canvas.drawColor(Color.rgb(color.r, color.g, color.b));
    }

    @Override
    public void translate(int x, int y) {
        canvas.translate(x, y);
    }

    @Override
    public void scale(int x, int y) {
        canvas.scale(x, y);
    }

    @Override
    public void save() {
        canvas.save();
    }

    @Override
    public void restore() {
        canvas.restore();
    }
}
