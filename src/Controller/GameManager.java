package Controller;

import Dao.GameProxyDao;
import Exceptions.VerificationException;
import Model.GameState;
import Model.Mode.GameMode;
import Utils.GameVerificator;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.Properties;

public class GameManager {

    private static GameManager gameManager = null;
    private GameProxyDao gameProxyDao;

    private GameManager() {

        gameProxyDao = new GameProxyDao();
    }

    public static GameManager getInstance(){
        if(gameManager == null){
            synchronized (GameManager.class) {
                if(gameManager == null){
                    gameManager = new GameManager();
                }
            }
        }
        return gameManager;
    }

    public GameProxyDao getGameProxyDao() {
        return gameProxyDao;
    }

    public void setPlayerMove(Long gameId, int colIndex) throws Exception {
        Game game = gameProxyDao.get(gameId).get();
            if (GameVerificator.verifyColumn(game.gameState.getBoard(), colIndex)) {
                game.setPlayerMove(colIndex);
            }
    }

    public GameState createNewGame(int gameModeInt) {
        GameMode gameMode = GameMode.values()[gameModeInt];
        Long gameId = getNextFreeGameId();
        Game game = new Game(gameMode, gameId);
        game.initialize();
        gameProxyDao.save(game);
        return game.getGameState();
    }

    public void closeGame(Long gameId) {
        Optional<Game> game = gameProxyDao.get(gameId);
        gameProxyDao.delete(game.get());
    }

    private Long getNextFreeGameId() {
        return gameProxyDao.getNextFreeGameId();
    }
}
