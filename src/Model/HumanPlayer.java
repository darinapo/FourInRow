package Model;

public class HumanPlayer extends AbstractPlayer{

    public HumanPlayer(int id, MoveStrategies strategy){

        super(id,strategy);
    }

    @Override
    public int Move() {
        return getStrategy().DoSomething();
    }
}
