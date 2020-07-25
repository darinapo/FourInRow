package Model.Level;

import Model.Board;

public interface LevelStrategy {
    public int chooseMove(Board board, int playerId);
}
