package Model;

public class ComputerPlayer extends AbstractPlayer {

    public ComputerPlayer(int id, MoveStrategies strategy) {

        super(id,strategy);
    }

    @Override
    public int Move() {
        return getStrategy().DoSomething();
    }
}
