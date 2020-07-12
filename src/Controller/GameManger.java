package Controller;
import Model.*;
import View.*;

public class GameManger extends GameTemplate{
    Board board = null;
    Print print = null;

    //----------------------------------------------
    @Override
    void Initialize() {
        //Future - add options to define the board space
        board = Board.GetBoardInstance();
        Print print = new Print();
        print.print(board);
    }

    @Override
    void StartPlay() {
        System.out.println("Start");

    }

    @Override
    void EndPlay() {
        System.out.println("End");

    }
}
