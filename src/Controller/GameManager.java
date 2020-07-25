package Controller;

import Dao.GameProxyDao;
import Model.GameState;
import Model.Mode.GameMode;

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

    public GameState createNewGame(int gameModeInt) {
        GameMode gameMode = GameMode.values()[gameModeInt];
        Long gameId = getNextFreeGameId();
        Game game = new Game(gameMode, gameId);
        game.initialize();
        gameProxyDao.save(game);
        return game.getGameState();
    }

    private Long getNextFreeGameId() {

        return gameProxyDao.getNextFreeGameId();
    }
}
