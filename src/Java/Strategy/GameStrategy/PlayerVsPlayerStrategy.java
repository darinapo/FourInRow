package Java.Strategy.GameStrategy;

import Java.Model.GameState;
import Java.Utils.GameVerificator;

public class PlayerVsPlayerStrategy implements GameStrategy {

    @Override
    public void setPlayerMove(GameState gameState, int colIndex) {
        int rowIndex = GameVerificator.firstEmptyRow(gameState.getBoard(), colIndex);
        gameState.getBoard().setPlayerDisc(rowIndex, colIndex, gameState.getCurrentPlayer());
        if (GameVerificator.isWinningDisc(gameState.getBoard(), rowIndex, colIndex)) {
            gameState.setWinner(true);
        }else {
            gameState.setNextPlayerTurn();
        }
        gameState.notifyStateChanged();
    }
}
