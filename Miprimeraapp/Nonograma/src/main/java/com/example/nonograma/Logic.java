package com.example.nonograma;

import com.example.engine.*;

import java.util.ArrayList;

public class Logic {
    private Engine engine;
    private Graphics graphics;
    private Audio audio;
    private Input input;
    private State state;

    private Font titleFont;
    private Font regularFont;
    private String titleFontFilename = "data/Fonts/Molle-Regular.ttf";
    private String regularFontFilename = "data/Fonts/JosefinSans-Bold.ttf";

    private int WIN_WIDTH, WIN_HEIGHT;
    private ArrayList<GameObject> gameObjects;

    public Logic(Engine engine_, int WIN_WIDTH, int WIN_HEIGHT) {
        engine = engine_;
        graphics = engine.getGraphics();
        audio = engine.getAudio();
        state = engine.getState();

        regularFont = graphics.newFont(regularFontFilename, 15, false);
        titleFont = graphics.newFont(titleFontFilename, 40, true);

        this.WIN_WIDTH = WIN_WIDTH;
        this.WIN_HEIGHT = WIN_HEIGHT;

        gameObjects = new ArrayList<GameObject>();

        MainMenu();
    }

    public void MainMenu() {
        Text titleText = new Text(this.WIN_WIDTH / 6, this.WIN_HEIGHT / 4, "NONOGRAMAS", titleFont);
        gameObjects.add(titleText);
    }

    public void SelectMenu() {

    }

    public void update (double deltaTime) {
        //state.update();
        for (GameObject gameObject : gameObjects)
            gameObject.update(deltaTime);
    }

    public void render() {
        //state.render(graphics);
        for (GameObject gameObject : gameObjects)
            gameObject.render(graphics);
    }
}
