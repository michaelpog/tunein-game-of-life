package game.of.life.steps.impl;

import game.of.life.states.CellStateHolder;
import game.of.life.steps.GameStep;

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
