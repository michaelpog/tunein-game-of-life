package game.of.life.state.management;

public interface StateChangeObservable {
    void register(StateChangeObserver observer);
}
