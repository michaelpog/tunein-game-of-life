package game.of.life.rules.imp;

import game.of.life.rules.NextStateStrategy;
import game.of.life.states.CellState;

public class OverCrowdingRule implements NextStateStrategy {
    @Override
    public CellState getNextState(CellState currentState, int numberOfLiveNeighbors) {
        if (currentState == CellState.DEAD) {
            return CellState.DEAD;
        }

        if (numberOfLiveNeighbors > 3) {
            return CellState.DEAD;
        }

        return CellState.ALIVE;
    }
}
