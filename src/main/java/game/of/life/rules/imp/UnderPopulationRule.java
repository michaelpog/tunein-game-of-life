package game.of.life.rules.imp;

import game.of.life.rules.NextStateStrategy;
import game.of.life.state.management.CellState;

public class UnderPopulationRule implements NextStateStrategy {
    @Override
    public CellState getNextState(CellState currentState, int numberOfLiveNeighbors) {
        if (numberOfLiveNeighbors < 2) {
            return CellState.DEAD;
        }

        return CellState.ALIVE;
    }
}
