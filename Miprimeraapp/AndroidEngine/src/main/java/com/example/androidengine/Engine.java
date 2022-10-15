package com.example.androidengine;

import android.content.Context;
import android.content.res.AssetManager;

import com.example.engine.Audio;
import com.example.engine.Graphics;
import com.example.engine.State;

public class Engine implements com.example.engine.Engine {
    private Graphics graphics;
    private Audio audio;
    private Input input;
    private State state;

    private int WIDTH, HEIGHT;

    public Engine(Context context, int win_width, int win_height) {
        super();
        WIDTH = win_width;
        HEIGHT = win_height;

        input = new Input();
        AssetManager assetManager = context.getAssets();
        audio = new com.example.androidengine.Audio(assetManager);
        graphics = new com.example.androidengine.Graphics(this);
    }

    @Override
    public Graphics getGraphics() {
        return graphics;
    }

    @Override
    public Audio getAudio() {
        return audio;
    }

    @Override
    public State getState() {
        return state;
    }
}
