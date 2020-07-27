package Java.Model;

import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @ClassRule
    final int row = 10;
    final int col =10;
    final int NumOfWinningDisks = 5;
    Board board = new Board(row,col,NumOfWinningDisks);

    @Test
    void getRowSize() {
        Assertions.assertEquals(row, board.getRowSize());
        Assertions.assertNotEquals(4, board.getRowSize());
    }

    @Test
    void getColumnSize() {
        Assertions.assertEquals(col, board.getColumnSize());
        Assertions.assertNotEquals(4, board.getColumnSize());
    }


    @Before
    public void SetBoard(){
        for(int i=0; i<board.getGameBoard().length;  i++)
            for(int j =0 ; i<board.getGameBoard()[0].length; j++)
                board.getGameBoard()[i][j] = 4;
    }
    @Test
    void resetBoard() {
        board.resetBoard();
        Assertions.assertTrue(board.BoardIsNotFull());
    }

    @Before
    public void SetMove(){
        for(int i=0; i<board.getGameBoard().length;  i++)
            for(int j =0 ; i<board.getGameBoard()[0].length; j++)
                board.getGameBoard()[i][j] = 0;
        board.setPlayerDisc(0,1,1);
    }
    @Test
    void getRowAfterPlayerMove() {
        Assertions.assertEquals(board.GetRowAfterPlayerMove(1),0);
    }


    @Before
    public void SetAlmostAllBoard(){
            for (int i = 0; i < board.getGameBoard().length; i++)
                for (int j = 0; i < board.getGameBoard()[0].length - 1; j++)
                    board.getGameBoard()[i][j] = 1;
    }
    @Test
    void boardIsNotFull() {
        Assertions.assertTrue(board.BoardIsNotFull());
    }

    @Before
    public void ClearSell(){

        board.getGameBoard()[9][9] = 0;
    }

    @Test
    void isEmptyCell() {
        Assertions.assertTrue(board.isEmptyCell(9,9));
    }
}