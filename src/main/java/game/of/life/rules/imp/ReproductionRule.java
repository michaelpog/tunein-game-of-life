package game.of.life.rules.imp;

import game.of.life.rules.NextStateStrategy;
import game.of.life.state.management.CellState;

public class ReproductionRule implements NextStateStrategy {
    @Override
    public CellState getNextState(CellState currentState, int numberOfLiveNeighbors) {
        if (currentState == CellState.ALIVE) {
            return CellState.ALIVE;
        }

        return numberOfLiveNeighbors == 3 ? CellState.ALIVE : CellState.DEAD;
    }
}
