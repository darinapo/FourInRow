package Strategy.Level;

import Model.Board;

import java.util.Random;

public class EasyStrategy implements LevelStrategy {
    @Override
    public int chooseMove(Board board, int playerId) {
        Random rand = new Random();
        return rand.nextInt(board.getColumnSize());//from 0 to colSize
    }
}
