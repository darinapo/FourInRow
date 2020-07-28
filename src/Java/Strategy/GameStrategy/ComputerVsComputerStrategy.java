package Java.Strategy.GameStrategy;

import Java.Controller.GameManager;
import Java.Events.EventsEnum;
import Java.Events.EventsHandler;
import Java.Model.GameState;
import Java.Utils.GameVerificator;

import static java.lang.Thread.*;

public class ComputerVsComputerStrategy implements GameStrategy {

    @Override
    public void setPlayerMove(GameState gameState, int colIndex) {
        int rowIndex = GameVerificator.firstEmptyRow(gameState.getBoard(), colIndex);
        gameState.getBoard().setPlayerDisc(rowIndex, colIndex, gameState.getCurrentPlayer());
        if (GameVerificator.isWinningDisc(gameState.getBoard(), rowIndex, colIndex)) {
            gameState.setWinner(true);
        }else {
            gameState.setNextPlayerTurn();
        }
//        gameState.notifyStateChanged();
        EventsHandler.getInstance().notifyEvent(EventsEnum.MOVE_PLAYED);

        try {
            sleep(1);
            colIndex = gameState.getPlayer(gameState.getCurrentPlayer()).getMove(gameState.getBoard());
            GameManager.getInstance().setPlayerMove(gameState.getGameId(), colIndex);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
