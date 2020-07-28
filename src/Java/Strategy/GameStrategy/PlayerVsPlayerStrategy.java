package Java.Strategy.GameStrategy;

import Java.Controller.GameManager;
import Java.Events.EventsEnum;
import Java.Events.EventsHandler;
import Java.Model.GameState;
import Java.Utils.GameVerificator;

public class PlayerVsPlayerStrategy implements GameStrategy {

    @Override
    public void setPlayerMove(GameState gameState, int colIndex) {
        int rowIndex = GameVerificator.firstEmptyRow(gameState.getBoard(), colIndex);
        gameState.getBoard().setPlayerDisc(rowIndex, colIndex, gameState.getCurrentPlayer());
        if (GameVerificator.isWinningDisc(gameState.getBoard(), rowIndex, colIndex)) {
            gameState.setWinner(true);
            EventsHandler.getInstance().notifyEvent(EventsEnum.WINNER);
            GameManager.getInstance().closeGame(gameState.getGameId());
        }else {
            gameState.setNextPlayerTurn();
            EventsHandler.getInstance().notifyEvent(EventsEnum.MOVE_PLAYED);
        }
//        gameState.notifyStateChanged();
    }
}
