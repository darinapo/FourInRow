package Model.Player;

import Model.Board;
import Model.Level.LevelStrategy;

public class ComputerPlayer extends AbstractPlayer {

    LevelStrategy levelStrategy;
    public ComputerPlayer(int id, String name/*, MoveStrategies strategy*/) {
        super(id, name/*,strategy*/);
    }

    public LevelStrategy getLevelStrategy() {
        return levelStrategy;
    }

    public void setLevelStrategy(LevelStrategy levelStrategy) {
        this.levelStrategy = levelStrategy;
    }

    @Override
    public int getMove(Board board) {
        return levelStrategy.chooseMove(board, getId());
    }

//    @Override
//    public int Move() {
//        return getStrategy().chooseMove();
//    }
}
