package Controller;
import Model.*;
import Model.Mode.GameMode;
import Model.Player.AbstractPlayer;
import Model.Player.PlayerEnum;
import Model.Player.PlayerFactory;
import View.*;
import java.util.ArrayList;
import java.util.Random;

//Maybe this is should be a singelton ? ? ?
public class Game extends GameTemplate{
//    protected Board board = null;
    protected ViewerInterface gui = null;
    protected ArrayList<AbstractPlayer> players = null;
    protected int numberOfPlayers = 2; //Default value
    protected int currentPlayer = -1; //Our IDs starts from 1
    protected int winner = -1;
//    protected VarificationInterface varificator;
    protected Long gameId;
    protected GameMode gameMode;
    protected GameState gameState;

    //-----------------------Constructor---------------------------
    public Game(GameMode gameMode, Long gameId){
        this.gameMode = gameMode;
        this.gameId = gameId;
    }

    public Long getGameId() {
        return gameId;
    }

    //----------------------Public Methods-------------------------
    @Override
    public void initialize() {
        gameState = new GameState(gameId, gameMode);
//        varificator = new Varificator();
        gui = new TerminalViewer();
        createBoard();
//        gui.display(board);
        createPlayers();
        setPlayerMove();
    }

    @Override
    public void startPlay() {
        System.out.println("Game Started");
        while (winner == -1 ){
            int id = players.get(currentPlayer).getId();
            int col = players.get(currentPlayer).getMove(gameState.getBoard()); // this one
            int row = gameState.getBoard().GetRowAfterPlayerMove(col);
            gameState.getBoard().setPlayerDisc(row,col,id);
            gui.display(gameState.getBoard());
//            if(varificator.Varificate(board,row, col)){
//                winner = id;
//                System.out.println("The winner is player:" + id);
//                break;
//            }
            if(gameState.getBoard().BoardIsNotFull()){
                NextPlayerTurn();
                continue;
            }

        }
    }

    @Override
    public void endPlay() { //Do we want to pass here the ID of the player?
        System.out.println("End");

    }

    public void createPlayers(){
        //TODO: Need to chose if he wants to play with a computer hardcoded or 2 players
//        numberOfPlayers = 2; //TO BE UPDATED
        PlayerFactory playerFactory = new PlayerFactory();
        //initializing players meanwhile we have human and a regular player as a demo
        //Do we want to do a strategy for validation?
        players = new ArrayList<AbstractPlayer>(numberOfPlayers);
        switch (gameMode) {
            case PlayerVsComp:
                gameState.addPlayer(playerFactory.getPlayer(PlayerEnum.Human));
                gameState.addPlayer(playerFactory.getPlayer(PlayerEnum.Computer));
                break;
            case PlayerVsPlayer:
                gameState.addPlayer(playerFactory.getPlayer(PlayerEnum.Human));
                gameState.addPlayer(playerFactory.getPlayer(PlayerEnum.Human));
                break;
            case ComputerVsComputer:
                gameState.addPlayer(playerFactory.getPlayer(PlayerEnum.Computer));
                gameState.addPlayer(playerFactory.getPlayer(PlayerEnum.Computer));
                break;
        }

    }

    public void createBoard(){
        //Future - add options to define the board space
        gameState.setBoard(new Board(8,8, 4)); //will need to be changed
    }

    //---------------------------Get / Set Functions-----------------
//
//    public int getNumberOfPlayers() {
//        return numberOfPlayers;
//    }
//
//    public void setNumberOfPlayers(int numberOfPlayers) {
//        this.numberOfPlayers = numberOfPlayers;
//    }

//    public ArrayList<AbstractPlayer> getPlayers() {
//        return players;
//    }
//
//    public void setPlayers(ArrayList<AbstractPlayer> players) {
//        this.players = players;
//    }


    public GameState getGameState() {
        return gameState;
    }

    public ViewerInterface getPrint() {
        return gui;
    }

    public void setPrint(ViewerInterface print) {
        gui = print;
    }

    //------------------------Private Methods ---------------------
    private void setPlayerMove(){
        Random rnd = new Random();
        currentPlayer = rnd.nextInt(numberOfPlayers);
    }
    private void NextPlayerTurn(){
        currentPlayer = ( currentPlayer + 1 ) % numberOfPlayers;
    }
}
