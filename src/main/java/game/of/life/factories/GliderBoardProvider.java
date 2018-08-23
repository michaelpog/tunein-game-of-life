package game.of.life.factories;

import game.of.life.Board;
import game.of.life.Cell;
import game.of.life.state.management.CellState;

public class GliderBoardProvider implements BoardProvider {
    public static final String NAME = "Glider";

    public Board createBoard(int numberOfRows, int numberOfColumns) {
        if (numberOfColumns < 6 || numberOfColumns < 6) {
            throw new RuntimeException("Board is too small");
        }

        Cell[][] cells = new Cell[numberOfRows][numberOfColumns];

        initializeAllCells(cells);

        createGliderPattern(cells);

        Board board = new Board(cells);
        return board;
    }

    private void initializeAllCells(Cell[][] cells) {
        for (int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells[0].length; col++) {
                cells[row][col] = new Cell(CellState.DEAD);
            }
        }
    }

    private void createGliderPattern(Cell[][] cells) {
        int midRow = cells.length / 2;
        int midColumn = cells[0].length / 2;

        cells[midRow][midColumn].updateInitialState(CellState.ALIVE);
        cells[midRow + 1][midColumn + 1].updateInitialState(CellState.ALIVE);
        cells[midRow + 2][midColumn + 1].updateInitialState(CellState.ALIVE);
        cells[midRow + 2][midColumn].updateInitialState(CellState.ALIVE);
        cells[midRow + 2][midColumn - 1].updateInitialState(CellState.ALIVE);
    }
}
