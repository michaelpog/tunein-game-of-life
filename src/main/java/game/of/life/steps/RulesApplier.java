package game.of.life.steps;

public interface RulesApplier extends Runnable {

    void await() throws InterruptedException;
}
