package game.of.life;

import game.of.life.factories.GameStepsFactory;
import game.of.life.states.CellStateHolder;
import game.of.life.steps.GameStep;

import java.util.List;

public class Game {
    private final CellStateHolder cellStateHolder;
    private final Board board;
    private final List<GameStep> gameStepList;

    public Game(Board board) {
        this.board = board;
        this.cellStateHolder = new CellStateHolder();
        initializeObservers();
        GameStepsFactory.create(board, cellStateHolder);
        gameStepList = GameStepsFactory.getInstance().getGameSteps();
    }

    private void initializeObservers() {
        for (int row = 0; row < board.getNumberOfRows(); row++) {
            for (int col = 0; col < board.getNumberOfColumns(); col++) {
                cellStateHolder.register(board.getCell(row, col));
            }
        }
    }

    public void start() {
        while (true) {
            for (GameStep gameStep : gameStepList) {
                gameStep.performStep();
            }
        }
    }


}
