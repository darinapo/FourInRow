package Controller;
import Model.*;
import View.*;
import java.util.ArrayList;
import java.util.Random;

//Maybe this is should be a singelton ? ? ?

public class GameManger extends GameTemplate{
    protected Board Board = null;
    protected PrintInterface Gui = null;
    protected ArrayList<AbstractPlayer> Players = null;
    protected int NumberOfPlayers = 0; //Default value
    protected int CurrentPlayer = -1; //Our IDs starts from 0
    protected int Winner = -1;
    protected VarificationInterface varificator;

    //-----------------------Constructor---------------------------
    public GameManger(){
    }

    //----------------------Public Methods-------------------------
    @Override
    public void Initialize() {
        varificator = new Varificator();
        Gui = new Print();
        CreateBoard();
        Gui.print(Board);
        CreatePlayers();
        SetPlayerMove();
    }

    @Override
    public void StartPlay() {
        System.out.println("Game Started");
        while (Winner == -1 ){
            int id = Players.get(CurrentPlayer).getId();
            int col = Players.get(CurrentPlayer).Move(); // this one
            int row = Board.GetRowAfterPlayerMove(col);
            Board.SetPlayerDisk(row,col,id);
            Gui.print(Board);
            if(varificator.Varificate(Board,row, col)){
                Winner = id;
                System.out.println("The winner is player:" + id);
                break;
            }
            if(Board.BoardIsNotFull()){
                NextPlayerTurn();
                continue;
            }

        }
    }

    @Override
    public void EndPlay() { //Do we want to pass here the ID of the player?
        System.out.println("End");

    }

    public void CreatePlayers(){
        //TODO: Need to chose if he wants to play with a computer hardcoded or 2 players
        NumberOfPlayers = 2; //TO BE UPDATED
        PlayerFactory playerFactory = new PlayerFactory();
        //initializing players meanwhile we have human and a regular player as a demo
        //Do we want to do a strategy for validation?
        Players = new ArrayList<AbstractPlayer>(NumberOfPlayers);
        Players.add(playerFactory.GetPlayer("Computer"));
        Players.add(playerFactory.GetPlayer("Computer"));
    }

    public void CreateBoard(){
        //Future - add options to define the board space
        Board = new Board(8,8); //will need to be changed
    }

    //---------------------------Get / Set Functions-----------------
    public Board getBoard() {
        return Board;
    }

    public void setBoard(Board board) {
        this.Board = board;
    }

    public int getNumberOfPlayers() {
        return NumberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        NumberOfPlayers = numberOfPlayers;
    }

    public ArrayList<AbstractPlayer> getPlayers() {
        return Players;
    }

    public void setPlayers(ArrayList<AbstractPlayer> players) {
        this.Players = players;
    }

    public PrintInterface getPrint() {
        return Gui;
    }

    public void setPrint(PrintInterface print) {
        Gui = print;
    }

    //------------------------Private Methods ---------------------
    private void SetPlayerMove(){
        Random rnd = new Random();
        CurrentPlayer = rnd.nextInt(NumberOfPlayers);
    }
    private void NextPlayerTurn(){
        CurrentPlayer = ( CurrentPlayer + 1 ) % NumberOfPlayers;
    }
}
