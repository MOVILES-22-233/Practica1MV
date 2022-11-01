package com.example.nonograma;

import com.example.engine.Engine;
import com.example.engine.Graphics;

import java.util.ArrayList;

public class Board extends GameObject {
    private Cell[][] cells;
    private Engine.Color grey;
    private Engine.Color red;
    private Engine.Color blue;

    public Board(int rows, int columns, int cell_side, Engine engine) {
        super(0,0,0, 0);
        cells = new Cell[rows][columns];

        // COLORES
        grey = new Engine.Color(211, 211, 211);
        red = new Engine.Color(256, 0, 0);
        blue = new Engine.Color(0, 0, 256);

        drawBoard(rows, columns, cell_side, engine);
    }

    private void drawBoard(int rows, int columns, int cell_side, Engine engine) {
        int posX = 0;
        int posY = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                Cell c = new Cell(posX, posY, cell_side, grey);
                posX += cell_side + cell_side/rows;
                cells[i][j] = c;
            }
            posX = 0;
            posY += cell_side + cell_side/columns;
        }
    }

    @Override
    public void update(double deltaTime) {

    }

    @Override
    public void render(Graphics graphics) {

    }
}
