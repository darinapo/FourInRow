package Model;

public class ComputerPlayer extends AbstractPlayer {

    public ComputerPlayer(int id) {
        super(id);
    }

    @Override
    public int Move() {
        return -1;
    }
}
