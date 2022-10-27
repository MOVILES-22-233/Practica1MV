package com.example.nonograma;

import com.example.engine.Engine;

import java.util.ArrayList;

public class Board {
    private ArrayList<Cell> cells;

    public Board(int num_cells, int cell_side, Engine engine) {
        cells = new ArrayList<Cell>();
        draw(num_cells, cell_side, engine);
    }

    private void draw(int num_cells, int cell_side, Engine engine) {
        int posX = 0;
        int posY = 0;
        Engine.Color grey = new Engine.Color(211, 211, 211);

        for (int i = 0; i < num_cells; i++) {
            for (int j = 0; j < num_cells; j++) {
                Cell c = new Cell(posX, posY, cell_side, grey);
                posX += cell_side + cell_side/num_cells;
                cells.add(c);
            }
            posX = 0;
            posY += cell_side + cell_side/num_cells;
        }
    }
}
