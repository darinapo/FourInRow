package Model;
import java.util.Random;

public class ComputerStrategy implements MoveStrategies{
    @Override
    public int chooseMove() {
        Random rand = new Random();
        return rand.nextInt(/*Board.ColumnSize*/7);//from 0 to colSize
    }
}
