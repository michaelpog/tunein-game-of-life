package game.of.life.factories;

import game.of.life.Board;
import game.of.life.game.steps.GameStep;
import game.of.life.game.steps.impl.*;
import game.of.life.state.management.CellStateHolder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameStepsFactory {
    private static GameStepsFactory instance;

    private List<GameStep> gameSteps;

    private GameStepsFactory(List<GameStep> gameSteps) {
        this.gameSteps = gameSteps;
    }

    public static void create(Board board, CellStateHolder cellStateHolder) {
        if (instance == null) {
            instance = new GameStepsFactory(createGameSteps(board, cellStateHolder));
        }
    }

    private static List<GameStep> createGameSteps(Board board, CellStateHolder cellStateHolder) {
        List<GameStep> newGameSteps = new ArrayList<>();
        newGameSteps.add(new NextGenerationGameStep(board));
        newGameSteps.add(new StateChangeGameStep(cellStateHolder));
        newGameSteps.add(new BoardPrinterGameStep(board));
        newGameSteps.add(new PauseGameStep(1000));
        //newGameSteps.add(new ReturnKeyWaiterGameStep());
        return Collections.unmodifiableList(newGameSteps);
    }

    public static GameStepsFactory getInstance() {
        if (instance == null) {
            throw new RuntimeException("The instance was not created yet");
        }

        return instance;
    }

    public List<GameStep> getGameSteps() {
        return gameSteps;
    }
}
