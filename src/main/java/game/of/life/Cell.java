package game.of.life;

public class Cell {
    public static final int NUMBER_OF_STATES = 2;
    public static final int INITIAL_STATE_INDEX = 0;
    private CellState[] states = new CellState[NUMBER_OF_STATES];

    public Cell(CellState initialState) {
        this.states[INITIAL_STATE_INDEX] = initialState;
        this.states[INITIAL_STATE_INDEX+1] = CellState.DEAD;
    }

    public void updateState(CellState nextCellState, int stateIndex) {
        states[stateIndex] = nextCellState;
    }

    public void updateInitialState(CellState cellState) {
        this.updateState(cellState, INITIAL_STATE_INDEX);
    }

    public CellState getCurrentCellState(int stateIndex) {
        return states[stateIndex];
    }

}
