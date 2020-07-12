package Model;

public class Validator implements ValidatotInterface {

    @Override
    public boolean ValidatePlayerMove(int move, Board board) { //Maybe to send just the row sizes?
        int rowSize = board.getRowSize();
        return (move > rowSize || move < 0);
    }
}
