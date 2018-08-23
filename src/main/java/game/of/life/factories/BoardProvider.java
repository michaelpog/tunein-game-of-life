package game.of.life.factories;

import game.of.life.Board;

public interface BoardProvider {
    Board createBoard(int numberOfRows, int numberOfColumns);
}
