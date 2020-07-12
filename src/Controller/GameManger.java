package Controller;
import Model.*;
import View.*;

import java.util.ArrayList;

public class GameManger extends GameTemplate{
    private Board board = null;
    public PrintInterface print = null;
    private ArrayList<AbstractPlayer> players = null;
    private int NumberOfPlayers = 0; //Default value



    public GameManger(){
         print = new Print();
    }

    //----------------------Public Methods-------------------------
    @Override
    public void Initialize() {
        CreateBoard();
        print.print(getBoard());
        AssignPlayers();
    }

    @Override
    public void StartPlay() {
        System.out.println("Game Started");

    }

    @Override
    public void EndPlay() { //Do we want to pass here the ID of the player?
        System.out.println("End");

    }
    public Board getBoard() {
        return board;
    }


    public void AssignPlayers(){
        //Need to chose if he wants to play with a computer hardcoded 2 players
        NumberOfPlayers = 2; //TO BE UPDATED
        PlayerFactory playerFactory = new PlayerFactory();
        //initializing players meanwhile we have human and a regular player as a demo
        //Do we want to do a strategy for validation?
        // note: we can use only array since array list is slower from what i hav read
        players = new ArrayList<AbstractPlayer>(NumberOfPlayers);
        players.add(playerFactory.GetPlayer("Computer"));
        players.add(playerFactory.GetPlayer("Human"));
    }

    public void CreateBoard(){
        //Future - add options to define the board space
        board = Board.GetBoardInstance();
    }

}
