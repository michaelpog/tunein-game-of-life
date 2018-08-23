package game.of.life.game.steps.impl;

import game.of.life.Board;
import game.of.life.game.steps.RulesApplier;
import game.of.life.rules.ParallelRulesApplier;
import game.of.life.game.steps.GameStep;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class NextGenerationGameStep implements GameStep {
    private final Board board;
    private final List<RulesApplier> parallelRulesAppliers = new ArrayList<>();
    private Executor fixedThreadPoolExecutor;

    public NextGenerationGameStep(Board board) {
        this.board = board;
        int numberOfCores = Runtime.getRuntime().availableProcessors();

        createThreadPool(numberOfCores);

        divideWork(numberOfCores);
    }

    private void createThreadPool(int numberOfCores) {
        this.fixedThreadPoolExecutor = Executors.newFixedThreadPool(numberOfCores);
    }

    private void divideWork(int numberOfRulesAppliers) {
        int portionSize = board.getNumberOfRows() / numberOfRulesAppliers;

        for (int ruleApplier = 0; ruleApplier < numberOfRulesAppliers; ruleApplier++) {
            int startRow = ruleApplier * portionSize;
            int endRow = ruleApplier < numberOfRulesAppliers - 1 ? startRow + portionSize - 1 : board.getNumberOfRows() - 1;
            parallelRulesAppliers.add(new ParallelRulesApplier(board, startRow, endRow));
        }
    }

    @Override
    public void performStep() {
        for (RulesApplier parallelApplier : parallelRulesAppliers) {
            fixedThreadPoolExecutor.execute(parallelApplier);
        }

        for (RulesApplier parallelApplier : parallelRulesAppliers) {
            try {
                parallelApplier.await();
            } catch (InterruptedException e) {
                System.out.println("A rules rules applier thread was interrupted, it's not safe to continue from here ");
                throw new RuntimeException("One of the threads died");
            }
        }

        //all threads are done we can continue
    }
}
