package game.of.life.rules;

import game.of.life.state.management.CellState;

public interface NextStateStrategy {
    CellState getNextState(CellState currentState, int numberOfLiveNeighbors);
}
