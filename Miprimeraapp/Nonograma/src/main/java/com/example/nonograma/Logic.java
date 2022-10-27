package com.example.nonograma;

import com.example.engine.*;

public class Logic {
    private Engine engine;
    private Graphics graphics;
    private Audio audio;
    private Input input;
    private State state;

    public Logic(Engine engine_) {
        engine = engine_;
        graphics = engine.getGraphics();
        audio = engine.getAudio();
        state = engine.getState();
    }

    public void MainMenu() {

    }

    public void SelectMenu() {

    }
}
