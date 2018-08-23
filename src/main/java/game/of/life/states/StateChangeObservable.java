package game.of.life.states;

public interface StateChangeObservable {
    void register(StateChangeObserver observer);
}
