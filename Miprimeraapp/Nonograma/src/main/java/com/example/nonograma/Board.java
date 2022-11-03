package com.example.nonograma;

import com.example.engine.Engine;
import com.example.engine.Graphics;

import java.util.ArrayList;

public class Board extends GameObject {
    private Cell[][] cells;
    private ArrayList<Engine.Vector2> answers;
    private Engine.Color grey;
    private Engine.Color red;
    private Engine.Color blue;

    public Board(int rows, int columns, int cell_side) {
        super(0,0,0, 0);
        cells = new Cell[rows][columns];
        answers = new ArrayList<Engine.Vector2>();

        // COLORES
        grey = new Engine.Color(211, 211, 211);
        red = new Engine.Color(256, 0, 0);
        blue = new Engine.Color(0, 0, 256);

        drawBoard(rows, columns, cell_side);
        makePuzzle(rows, columns);
        int x = 0;
    }

    private void drawBoard(int rows, int columns, int cell_side) {
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

    private void makePuzzle(int rows, int columns) {
        // Calculamos el numero maximo de celdas que pueden ir juntas
        int numMaxAdjacentCells;
        // Caso 1: el puzzle es un cuadrado, entonces no importa si se toma en cuenta filas o columnas
        if (rows == columns) {
            if (rows % 2 == 0) numMaxAdjacentCells = rows / 2;
            else numMaxAdjacentCells = rows / 2 + 1;
            makePuzzleByColumn(columns, rows, numMaxAdjacentCells);
        }
        // Caso 2: el puzzle es un rectangulo, entonces usamos la dimension mas larga para calcular numMaxAdjacentCells
        else {
            if (rows > columns) {
                if (rows % 2 == 0) numMaxAdjacentCells = rows / 2;
                else numMaxAdjacentCells = rows / 2 + 1;
                makePuzzleByRows(rows, numMaxAdjacentCells);
            }
            else {
                if (columns % 2 == 0) numMaxAdjacentCells = columns / 2;
                else numMaxAdjacentCells = columns / 2 + 1;
                makePuzzleByColumn(columns, rows, numMaxAdjacentCells);
            }
        }
    }

    public void makePuzzleByColumn(int numColumns, int numRows, int numMaxAdjacentCells) {
        int numAdjacentCells;
        int currentRow;
        int remainingCellsInColumn;
        for (int i = 0; i < numColumns; i++) {
            currentRow = 0;
            remainingCellsInColumn = numColumns;
            while (currentRow < numRows) {
                if (remainingCellsInColumn > 1 && this.cells[i][currentRow].getValue() == 0 && CheckUpperCell(i, currentRow)) {
                    do {
                        numAdjacentCells = (int) (Math.random() * numMaxAdjacentCells) + 1;
                    } while (numAdjacentCells >= remainingCellsInColumn);

                    remainingCellsInColumn -= numAdjacentCells;
                    for (int j = 0; j < numAdjacentCells; j++) {
                        this.cells[i][currentRow + j].setValue(1);
                    }
                    currentRow += numAdjacentCells;
                } else {
                    currentRow++;
                    remainingCellsInColumn--;
                }
            }
        }
    }

    public void makePuzzleByRows(int numRows, int numMaxAdjacentCells) {
        int numAdjacentCells;
        int currentColumn = 0;
        int remainingCellsInRow = numRows;
        for (int j = 0; j < numRows; j++) {
            if (this.cells[currentColumn][j].getValue() == 0 && !CheckUpperCell(currentColumn, j)) {
                do {
                    numAdjacentCells = (int) (Math.random() * numMaxAdjacentCells) + 1;
                } while (numAdjacentCells >= remainingCellsInRow);

                remainingCellsInRow -= numAdjacentCells;
                for (int i = currentColumn; i < numAdjacentCells; i++) {
                    this.cells[i][j].setValue(1);
                }
                currentColumn += numAdjacentCells;
            }
        }
    }

    private boolean CheckUpperCell(int i, int j) {
        if (i == 0 && j == 0)
            return true;

        if (i == 0 && j > 0)
            return this.cells[i][j - 1].getValue() == 0;
        else if (j != 0 && i != 0) return this.cells[i - 1][j - 1].getValue() == 0;
        else return false;
    }

    private boolean CheckAdjacentCell(int i, int j) {
        if (i == 0 && j == 0)
            return false;
        else if (i > 0 && j == 0)
            return this.cells[i - 1][j].getValue() == 0;
        else return this.cells[i - 1][j - 1].getValue() == 0;
    }

    @Override
    public void update(double deltaTime) {

    }

    @Override
    public void render(Graphics graphics) {

    }
}
