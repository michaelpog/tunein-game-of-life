package game.of.life.game.steps.impl;

import game.of.life.state.management.CellStateHolder;
import game.of.life.game.steps.GameStep;

public class StateChangeGameStep implements GameStep {
    private CellStateHolder cellStateHolder;

    public StateChangeGameStep(CellStateHolder cellStateHolder) {
        this.cellStateHolder = cellStateHolder;
    }

    @Override
    public void performStep() {
        cellStateHolder.moveToNextState();
    }
}
