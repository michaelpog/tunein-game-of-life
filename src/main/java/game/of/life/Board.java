package game.of.life;

public class Board {
    private final Cell[][] cells;
    private final int numberOfRows;
    private final int numberOfColumns;

    public Board(Cell[][] cells) {
        this.cells = cells;
        this.numberOfRows = cells.length;
        this.numberOfColumns = cells[0].length;
    }

    public Cell getCell(int row, int col) {
        return cells[row][col];
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public int getNumberOfColumns() {
        return numberOfColumns;
    }
}
