package com.example.nonograma;

import com.example.engine.*;
import com.sun.org.apache.xalan.internal.xsltc.compiler.Parser;

import java.util.ArrayList;
import java.util.Vector;

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

    private Engine.Vector2 winSize;

    private int WIN_WIDTH, WIN_HEIGHT;
    private int width, height;
    private ArrayList<GameObject> gameObjects;
    private ArrayList<Caller> callers;

    public Logic(Engine engine, int WIN_WIDTH, int WIN_HEIGHT) {
        this.engine = engine;
        graphics = engine.getGraphics();
        audio = engine.getAudio();
        state = engine.getState();
        input = engine.getInput();

        regularFont = graphics.newFont(regularFontFilename, 15, false);
        titleFont = graphics.newFont(titleFontFilename, 40, true);

        this.WIN_WIDTH = WIN_WIDTH;
        this.WIN_HEIGHT = WIN_HEIGHT;

        gameObjects = new ArrayList<GameObject>();
        callers = new ArrayList<Caller>();

        MainMenu();
    }

    public void MainMenu() {
        Text titleText = new Text(this.WIN_WIDTH / 6, this.WIN_HEIGHT / 4, "NONOGRAMAS", titleFont, "");
        gameObjects.add(titleText);
        Text playButton = new Text(this.WIN_WIDTH / 2, this.WIN_HEIGHT / 2, "PLAY", regularFont, "PlayButton");
        gameObjects.add(playButton);
        callers.add(playButton);
        Board board = new Board(4, 4, 4);
    }

    public void SelectMenu() {
        Text titleText = new Text(this.WIN_WIDTH / 6, this.WIN_HEIGHT / 4, "PUTO", titleFont, "");
        gameObjects.add(titleText);
    }

    public void deleteElements() {
        if (gameObjects.size() > 0)
            gameObjects.clear();
        if (callers.size() > 0)
            callers.clear();
    }

    public void update (double deltaTime) {
        //state.update();
        for (GameObject gameObject : gameObjects)
            gameObject.update(deltaTime);
    }

    public void render() {
        //state.render(graphics);
        winSize = graphics.adjustToWindow();
        width = winSize.x;
        height = winSize.y;
        for (GameObject gameObject : gameObjects)
            gameObject.render(graphics);
    }

    public void handleInput() {
        /*while (input.getTouchEvents().size() > 0) {
            for (Input.TouchEvent event : input.getTouchEvents()) {
                // AGARRAMOS LAS COORDENADAS REALES
                Engine.Vector2 mousePos = transformCoordinates(new Engine.Vector2(event.pos.x, event.pos.y), winSize);
                for (Caller caller : callers) {
                    switch (caller.getFunction()) {
                        case "PlayButton":
                            if (event.type == Input.TouchEvent.Type.PRESS && ((Text)caller).inBounds(mousePos.x, mousePos.y)) {
                                deleteElements();
                                SelectMenu();
                            }
                            break;
                        default: break;
                    }
                }
            }
            input.getTouchEvents().clear();
        }*/
    }

    public Engine.Vector2 transformCoordinates(Engine.Vector2 coord, Engine.Vector2 winSize) {
        float incX = this.WIN_WIDTH / winSize.x;
        float incY = this.WIN_HEIGHT / winSize.y;

        coord.x -= winSize.x / 2;
        coord.y -= winSize.y / 2;

        float distWidth = winSize.x - this.WIN_WIDTH;
        float distHeight = winSize.y - this.WIN_HEIGHT;

        if (distWidth > distHeight) {
            coord.x *= incY;
            coord.y *= incY;
        }
        else {
            coord.x *= incX;
            coord.y *= incX;
        }

        return coord;
    }
}
