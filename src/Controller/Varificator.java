package Controller;
import Model.*;

public class Varificator implements VarificationInterface {
    private int PlayerId;
    private int DiskCount = 0;
    private final int AmountDisksForWinning = 4;

    @Override
    public boolean Varificate(Board board, int row, int col) {
        PlayerId = board.getGameBoard()[row][col];
        return(CheckHorizontal(board, row, col) || CheckDiagonal(board, row ,col)||
                CheckCDiagonalOverLeftToRight(board, row ,col) ||
                CheckCDiagonalOverRighToLeft(board, row ,col));
    }
//-----------------------------------------------------------------
    protected boolean CheckHorizontal(Board board, int row, int col) {
        DiskCount = 1;
        int j = col + 1;
        while (j < board.getColumnSize()) {//in range of the row ------>
            if (board.getGameBoard()[row][j] == PlayerId) {
                DiskCount++;
                if (DiskCount == AmountDisksForWinning)
                    return true;
                j++;
            } else {
                DiskCount = 0;
                break;
            }
        }
        DiskCount = 1;
        j = col - 1;
        while (j >= 0) {//in range of the row <------------
            if (board.getGameBoard()[row][j] == PlayerId) {
                DiskCount++;
                if (DiskCount == AmountDisksForWinning)
                    return true;
                j--;
            } else {
                DiskCount = 0;
                break;
            }
        }
        return false;
    }
//-----------------------------------------------------------------
    protected boolean CheckDiagonal(Board board, int row, int col){
        DiskCount = 1;
        int i = row + 1;
        while (i < board.getRowSize() && i>=0) {//in range of the row
            if (board.getGameBoard()[i][col] == PlayerId) {
                DiskCount++;
                if (DiskCount == AmountDisksForWinning)
                    return true;
                i++;
            } else {
                DiskCount = 0;
                break;
            }
        }
        DiskCount = 1;
        i = row - 1;
        while (i >= 0) {//in range of the row
            if (board.getGameBoard()[i][col] == PlayerId) {
                DiskCount++;
                if (DiskCount == AmountDisksForWinning)
                    return true;
                i--;
            } else {
                DiskCount = 0;
                break;
            }
        }
        return false;
    }
//-----------------------------------------------------------------
    protected boolean CheckCDiagonalOverLeftToRight(Board board, int row, int col){
        DiskCount = 1;
        int i = row - 1;
        int j = col  - 1;
        while (i >=0 && j>=0 ) {//Going backwards on the crossover
            if (board.getGameBoard()[i][j] == PlayerId) {
                DiskCount++;
                if (DiskCount == AmountDisksForWinning)
                    return true;
                i--;
                j--;
            } else {
                DiskCount = 0;
                break;
            }
        }
        DiskCount = 1;
        i = row + 1;
        j = col + 1;
        while (i < board.getRowSize() && i>=0 && j < board.getColumnSize() && j>=0) {//in range of the row
            if (board.getGameBoard()[i][j] == PlayerId) {
                DiskCount++;
                if (DiskCount == AmountDisksForWinning)
                    return true;
                i++;
                j++;
            } else {
                DiskCount = 0;
                break;
            }
        }
        return false;
    }

    //-----------------------------------------------------------------

    protected boolean CheckCDiagonalOverRighToLeft(Board board, int row, int col) {
        DiskCount = 1;
        int i = row + 1;
        int j = col - 1;
        while (i < board.getRowSize() && i>=0 && j>=0 ) {//Going backwards on the crossover li
            if (board.getGameBoard()[i][j] == PlayerId) {
                DiskCount++;
                if (DiskCount == AmountDisksForWinning)
                    return true;
                i++;
                j--;
            } else {
                DiskCount = 0;
                break;
            }
        }
        DiskCount = 1;
        i = row - 1;
        j = col + 1;
        while (i >= 0 && j < board.getColumnSize() && j>=0) {//in range of the row
            if (board.getGameBoard()[i][i] == PlayerId) {
                DiskCount++;
                if (DiskCount == AmountDisksForWinning)
                    return true;
                i--;
                j++;
            } else {
                DiskCount = 0;
                break;
            }
        }
        return false;
    }
}

