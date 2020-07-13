package Controller;
import Model.*;
import View.*;
import java.util.ArrayList;

//Maybe this is should be a singelton ? ? ?

public class GameManger extends GameTemplate{
    protected Board Board = null;
    protected PrintInterface Gui = null;
    protected ArrayList<AbstractPlayer> Players = null;
    protected int NumberOfPlayers = 0; //Default value
    protected ValidatotInterface Validator = null;


    //-----------------------Constructor---------------------------
    public GameManger(){
    }

    //----------------------Public Methods-------------------------
    @Override
    public void Initialize() {
        Gui = new Print();
        CreateBoard();
        Gui.print(getBoard());
        CreatePlayers();
    }

    @Override
    public void StartPlay() {
        System.out.println("Game Started");

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
        Players.add(playerFactory.GetPlayer("Human"));
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

    public ValidatotInterface getValidator() {
        return Validator;
    }

    public void setValidator(ValidatotInterface validator) {
        Validator = validator;
    }
}
