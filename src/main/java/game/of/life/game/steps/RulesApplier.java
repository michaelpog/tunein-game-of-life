package game.of.life.game.steps;

public interface RulesApplier extends Runnable {
    void await() throws InterruptedException;
}
