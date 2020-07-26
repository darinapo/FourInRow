package Java.Strategy.GameStrategy;

import Java.Model.GameState;

public interface GameStrategy {
    public void setPlayerMove (GameState gameState, int colIndex);
}
