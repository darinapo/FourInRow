package Java.Strategy.Level;

import Java.Model.Board;

public interface LevelStrategy {
    public int chooseMove(Board board, int playerId);
}
