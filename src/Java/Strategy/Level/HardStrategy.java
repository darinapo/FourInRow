package Java.Strategy.Level;

import Java.Model.Board;

import java.util.Random;

public class HardStrategy implements LevelStrategy {
    @Override
    public int chooseMove(Board board, int playerId) {
        Random rand = new Random();
        return rand.nextInt(board.getColumnSize());//from 0 to colSize
    }
}
