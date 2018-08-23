package game.of.life.game.steps.impl;

import game.of.life.Board;
import game.of.life.state.management.CellState;
import game.of.life.game.steps.GameStep;

public class BoardPrinterGameStep implements GameStep {
    private Board board;

    public BoardPrinterGameStep(Board board) {
        this.board = board;
    }

    @Override
    public void performStep() {
        printBoard(this.board);
    }

    private static void clearScreen() {
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public static void printBoard(Board board) {
        clearScreen();
        for (int row = 0; row < board.getNumberOfRows(); row++) {
            for (int col = 0; col < board.getNumberOfColumns(); col++) {
                if (board.getCell(row, col).getCurrentCellState() == CellState.ALIVE) {
                    System.out.print("L ");
                } else {
                    System.out.print("D ");
                }
            }
            System.out.println();
        }
    }
}
