package Java.Controller;

import Java.Dao.GameProxyDao;
import Java.Events.EventsEnum;
import Java.Events.EventsHandler;
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

    public static GameManager getInstance() {
        if (gameManager == null) {
            synchronized (GameManager.class) {
                if (gameManager == null) {
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

    public GameState createNewGame(int gameMenuItem) throws Exception {
        GameMode gameMode = GameMode.values()[gameMenuItem];
        if (gameMode.equals(GameMode.Quit)){
            EventsHandler.getInstance().notifyEvent(EventsEnum.QUIT);
            return null;
        }else {
            Long gameId = getNextFreeGameId();
//            Game game = (Game) DebugProxy.newInstance(new Game(gameMode, gameId));
            Game game = new Game(gameMode, gameId);
            game.initialize();
            gameProxyDao.save(game);
            return game.getGameState();
        }
    }

    public void closeGame(Long gameId) {
        Optional<Game> game = gameProxyDao.get(gameId);
        gameProxyDao.delete(game.get());
//        DebugProxy.close_inner_file();
    }

    private Long getNextFreeGameId() {
        return gameProxyDao.getNextFreeGameId();
    }
}
