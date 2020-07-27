package Java.Controller;

import Java.Dao.GameProxyDao;
import Java.Exceptions.NotValidGameModeException;
import Java.Exceptions.QuitKeyInserted;
import Java.Model.GameState;
import Java.Model.Mode.GameMode;
import Java.Utils.GameVerificator;

import java.util.Optional;

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

    public GameState createNewGame(int gameModeInt) throws NotValidGameModeException {
    try {
        GameMode gameMode = GameMode.values()[gameModeInt];
        Long gameId = getNextFreeGameId();
        Game game = new Game(gameMode, gameId);
        game.initialize();
        gameProxyDao.save(game);
        return game.getGameState();
    }
    catch (Exception e){
        throw new NotValidGameModeException("Not valid game mode requested");
        }
    }

    public void closeGame(Long gameId) {
        Optional<Game> game = gameProxyDao.get(gameId);
        gameProxyDao.delete(game.get());
    }

    private Long getNextFreeGameId() {
        return gameProxyDao.getNextFreeGameId();
    }
}
