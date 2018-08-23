package game.of.life.game.steps.impl;

import game.of.life.game.steps.GameStep;

import java.io.IOException;

public class ReturnKeyWaiterGameStep implements GameStep {

    @Override
    public void performStep() {
        try {
            System.in.read();
        } catch (IOException e) {

        }
    }
}
