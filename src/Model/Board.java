package Model;
import java.util.ArrayList;
import java.util.Arrays;
//Singelton class
public class Board{
    private int RowSize = 8;//default value
    private int ColumnSize = 8;//default value
    private int[][] GameBoard; //Game board
    private static Board BoardInstance = null;

    //---------------------Private Methods----------------------------------
    private Board(){
        //default 8*8
        GameBoard = new int[RowSize][ColumnSize];
        ResetBoard(); //resetting board with -1
    }

    //---------------------Public Methods-----------------------------------
    public static Board GetBoardInstance(){
       if(BoardInstance == null)
           BoardInstance = new Board();
       return BoardInstance;
    }

    public int getColumnSize() {
        return ColumnSize;
    }

    public int getRowSize() {
        return RowSize;
    }

    public int[][] getGameBoard() {
        return GameBoard;
    }
    public void ResetBoard(){
        System.out.println("Resetting board:");
        for(int row = 0 ; row < RowSize; row++){
            for(int col = 0 ; col < ColumnSize; col++){
                GameBoard[row][col] = -1;
            }
        }
    }
}

