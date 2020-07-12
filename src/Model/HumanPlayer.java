package Model;

public class HumanPlayer extends AbstractPlayer{

    public HumanPlayer(int player){
        this.setId(player);
    }

    @Override
    public int Move() {
        return -1;
    }
}
