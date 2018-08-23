package game.of.life.state.management;

import java.util.ArrayList;
import java.util.List;

public class CellStateHolder implements StateChangeObservable {
    private List<StateChangeObserver> observerList = new ArrayList<>();

    public void moveToNextState() {
        for (StateChangeObserver observer : observerList) {
            observer.changeState();
        }
    }

    @Override
    public void register(StateChangeObserver observer) {
        observerList.add(observer);
    }
}
