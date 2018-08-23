package game.of.life;

import java.util.function.Supplier;

public class CellStateHolder implements Supplier<Integer> {
    private volatile int currentStateIndex = Cell.INITIAL_STATE_INDEX;

    @Override
    public Integer get() {
        return currentStateIndex;
    }

    public void moveToNextState() {
        currentStateIndex = Cell.NUMBER_OF_STATES - currentStateIndex;
    }
}
