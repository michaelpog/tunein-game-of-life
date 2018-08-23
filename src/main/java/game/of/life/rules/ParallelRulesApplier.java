package game.of.life.rules;

import game.of.life.Board;
import game.of.life.Cell;
import game.of.life.factories.RulesFactory;
import game.of.life.game.steps.RulesApplier;
import game.of.life.state.management.CellState;

import java.util.Set;
import java.util.concurrent.Semaphore;

public class ParallelRulesApplier implements RulesApplier {
    private final Board board;
    private final int startRow;
    private final int endRow;
    private Semaphore finishSignalSemaphore = new Semaphore(0);
    private final Set<NextStateStrategy> rules = RulesFactory.getInstance().getRules();


    public ParallelRulesApplier(Board board, int startRow, int endRow) {
        this.board = board;
        this.startRow = startRow;
        this.endRow = endRow;
    }

    @Override
    public void run() {
        for (int row = startRow; row <= endRow; row++) {
            for (int col = 0; col < board.getNumberOfColumns(); col++) {
                int numberOfNeighbors = calculateNumberOfLiveNeighbors(row, col);
                Cell currentCell = board.getCell(row, col);
                CellState currentState = currentCell.getCurrentCellState();

                CellState nextState = getNextState(currentState, numberOfNeighbors);

                currentCell.updateNextState(nextState);
            }
        }

        finishSignalSemaphore.release();
    }

    private CellState getNextState(CellState currentState, int numberOfNeighbors) {
        for (NextStateStrategy rule : rules) {
            CellState nextState = rule.getNextState(currentState, numberOfNeighbors);
            if (nextState != currentState) {
                return nextState;
            }
        }
        return currentState;
    }

    private int calculateNumberOfLiveNeighbors(final int row, final int col) {
        int liveNeighbors = 0;
        for (int neighborRow = row - 1; neighborRow <= row + 1; neighborRow++) {
            for (int neighborCol = col - 1; neighborCol <= col + 1; neighborCol++) {
                if (neighborCol == 0 && neighborRow == 0) {
                    continue;
                }

                if (!isValidCoordinate(neighborRow, neighborCol)) {
                    continue;
                }

                if (board.getCell(neighborRow, neighborCol).getCurrentCellState() == CellState.ALIVE) {
                    liveNeighbors++;
                }
            }
        }

        return liveNeighbors;
    }

    private boolean isValidCoordinate(int row, int col) {
        return col >= 0 && row >= 0 && col < board.getNumberOfColumns() && row < board.getNumberOfRows();
    }


    @Override
    public void await() throws InterruptedException {
        finishSignalSemaphore.acquire();
    }
}
