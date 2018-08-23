package game.of.life;

import game.of.life.factories.GliderBoardProvider;
import game.of.life.factories.InputBoardFactory;

public class Main {
    public static final int NUMBER_OF_COLUMNS = 25;
    public static final int NUMBER_OF_ROWS = 25;

    public static void main(String[] args) {
        Board board = InputBoardFactory.getInstance().createBoard(GliderBoardProvider.NAME, NUMBER_OF_ROWS, NUMBER_OF_COLUMNS);
        Game game = new Game(board);
        game.start();
    }
}
