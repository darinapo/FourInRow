package Model;
import java.util.Random;

public class ComputerStrategy implements MoveStrategies{
    @Override
    public int DoSomething() {
        Random rand = new Random();
        return rand.nextInt(Board.RowSize+1);//from 0 to rowSize
    }
}
