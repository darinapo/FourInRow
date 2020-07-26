package Java.Controller;
import Java.Model.*;
import Java.Model.Mode.GameLevel;
import Java.Model.Mode.GameMode;
import Java.Model.Player.PlayerEnum;
import Java.Model.Player.PlayerFactory;
import Java.Strategy.GameStrategy.GameStrategy;
import Java.Strategy.GameStrategy.GameStrategyFactory;
import Java.Utils.Constants;

public class Game extends GameTemplate{
    protected Long gameId;
    protected GameMode gameMode;
    protected GameState gameState;
    private GameStrategy gameStrategy;

    //-----------------------Constructor---------------------------
    public Game(GameMode gameMode, Long gameId){
        this.gameMode = gameMode;
        this.gameId = gameId;
    }

    public void setGameLevel(int gameLevelInt) {
        getGameState().setGameLevel(GameLevel.values()[gameLevelInt]);

    }

    public Long getGameId() {
        return gameId;
    }

    //----------------------Public Methods-------------------------
    @Override
    public void initialize() {
        gameState = new GameState(gameId, gameMode);
        setGameStrategy();
        createBoard();
        createPlayers();
    }

    @Override
    public void startPlay() {
        System.out.println("Game Started");
//        while (winner == -1 ){
//            int id = gameState.getPlayers().get(currentPlayer).getId();
//            int col = gameState.getPlayers().get(currentPlayer).getMove(gameState.getBoard()); // this one
//            int row = gameState.getBoard().GetRowAfterPlayerMove(col);
//            gameState.getBoard().setPlayerDisc(row,col,id);
////            gui.display(gameState.getBoard());
////            if(varificator.Varificate(board,row, col)){
////                winner = id;
////                System.out.println("The winner is player:" + id);
////                break;
////            }
//            if(gameState.getBoard().BoardIsNotFull()){
//                NextPlayerTurn();
//                continue;
//            }
//
//        }
    }

    @Override
    public void endPlay() { //Do we want to pass here the ID of the player?
        System.out.println("End");

    }

    private void setGameStrategy() {
        GameStrategyFactory gameStrategyFactory = new GameStrategyFactory();
        this.gameStrategy = gameStrategyFactory.getGameStrategy(gameMode);
    }

    public void createPlayers(){
        //TODO: Need to chose if he wants to play with a computer hardcoded or 2 players
        System.out.println("Creating players");
        PlayerFactory playerFactory = new PlayerFactory();
        //initializing players meanwhile we have human and a regular player as a demo
        switch (gameMode) {
            case PlayerVsComp:
                gameState.addPlayer(playerFactory.getPlayer(PlayerEnum.Human, Constants.FIRST_PLAYER_ID));
                gameState.addPlayer(playerFactory.getPlayer(PlayerEnum.Computer, Constants.SECOND_PLAYER_ID));
                break;
            case PlayerVsPlayer:
                gameState.addPlayer(playerFactory.getPlayer(PlayerEnum.Human, Constants.FIRST_PLAYER_ID));
                gameState.addPlayer(playerFactory.getPlayer(PlayerEnum.Human, Constants.SECOND_PLAYER_ID));
                break;
            case ComputerVsComputer:
                gameState.addPlayer(playerFactory.getPlayer(PlayerEnum.Computer, Constants.FIRST_PLAYER_ID));
                gameState.addPlayer(playerFactory.getPlayer(PlayerEnum.Computer, Constants.SECOND_PLAYER_ID));
                break;
        }
        System.out.println("After Creating players");
    }

    public void createBoard(){
        //Future - add options to define the board space
        gameState.setBoard(new Board(8,8, 4)); //will need to be changed
    }

    public void setPlayerMove (int colIndex) {
        gameStrategy.setPlayerMove(gameState, colIndex);
    }

    public GameState getGameState() {
        return gameState;
    }

}
