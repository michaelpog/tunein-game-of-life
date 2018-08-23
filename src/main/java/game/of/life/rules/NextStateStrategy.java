package game.of.life.rules;

import game.of.life.states.CellState;

public interface NextStateStrategy {
    CellState getNextState(CellState currentState, int numberOfLiveNeighbors);
}
