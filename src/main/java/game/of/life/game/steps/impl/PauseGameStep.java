package game.of.life.game.steps.impl;

import game.of.life.game.steps.GameStep;

public class PauseGameStep implements GameStep {
    private final long pauseTimeMs;

    public PauseGameStep(long pauseTimeMs) {
        this.pauseTimeMs = pauseTimeMs;
    }

    @Override
    public void performStep() {
        try {
            Thread.sleep(pauseTimeMs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
