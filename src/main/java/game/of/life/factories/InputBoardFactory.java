package game.of.life.factories;

import game.of.life.Board;

import java.util.HashMap;
import java.util.Map;

public class InputBoardFactory {
    private static InputBoardFactory instance;
    private Map<String, BoardProvider> providersMap = new HashMap<>();

    private InputBoardFactory() {
        providersMap.put(GliderBoardProvider.NAME, new GliderBoardProvider());
    }

    public static InputBoardFactory getInstance() {
        if (instance == null) {
            instance = new InputBoardFactory();
        }

        return instance;
    }

    public Board createBoard(String providerName, int numberOfRows, int numberOfColumns) {
        if (!providersMap.containsKey(providerName)) {
            throw new RuntimeException(providerName + ": provider doesn't exist");
        }

        return providersMap.get(providerName).createBoard(numberOfRows, numberOfColumns);
    }
}
