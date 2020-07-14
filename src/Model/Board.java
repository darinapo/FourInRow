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
                GameBoard[row][col] = 0;
            }
        }
    }

    //Getting the exact cell number after the player chose
    //a column to insert
    public int GetRowAfterPlayerMove(int col){
        int i = 0;
        while(i<getRowSize()){
            if(GameBoard[i][col] != 0){
                i++;
            }
            else
                break;
        }
        return i;
    }


    //Maybe can be optimized?
    public boolean BoardIsNotFull(){
        for(int i = 0 ; i< RowSize ; i++) {
            for (int j = 0; j < ColumnSize; j++) {
                if (GameBoard[i][j] == 0)
                    return true;
            }
        }
        return false;
    }
    public void SetPlayerDisk(int row, int col , int playerId){
        GameBoard[row][col] = playerId;
    }
}

