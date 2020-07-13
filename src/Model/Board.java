package Model;
import java.util.ArrayList;
import java.util.Arrays;

public class Board{
    static int RowSize;
    static int ColumnSize;
    static int[][] GameBoard; //Game board

    //---------------------Private Methods----------------------------------
    public Board(int row , int col ){
        //default 8*8
        RowSize = row;
        ColumnSize = col;
        GameBoard = new int[RowSize][ColumnSize];
        ResetBoard();
    }

    //---------------------Public Methods-----------------------------------

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

