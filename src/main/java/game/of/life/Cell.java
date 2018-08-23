package game.of.life;

import game.of.life.states.CellState;
import game.of.life.states.StateChangeObserver;

public class Cell implements StateChangeObserver {
    public static final int NUMBER_OF_STATES = 2;
    public static final int INITIAL_STATE_INDEX = 0;
    private CellState[] states = new CellState[NUMBER_OF_STATES];
    private int currentIndex = INITIAL_STATE_INDEX;

    public Cell(CellState initialState) {
        this.states[INITIAL_STATE_INDEX] = initialState;
        this.states[INITIAL_STATE_INDEX + 1] = CellState.DEAD;
    }

    public void updateNextState(CellState nextCellState) {
        int nextStateIndex = getNextStateIndex();
        states[nextStateIndex] = nextCellState;
    }

    public void updateInitialState(CellState cellState) {
        states[currentIndex] = cellState;
    }

    public CellState getCurrentCellState() {
        return states[currentIndex];
    }

    private int getNextStateIndex() {
        return (currentIndex + 1) % NUMBER_OF_STATES;
    }

    @Override
    public void changeState() {
        currentIndex = getNextStateIndex();
    }
}
