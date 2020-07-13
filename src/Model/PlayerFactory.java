package Model;
//Maybe abstract factory?
public class PlayerFactory {

    private int PlayerId = 0; //default value
    public AbstractPlayer GetPlayer(String player){
        PlayerId++;
        if(player == "human") {
            return new HumanPlayer(PlayerId, new HumanStrategy());
        }
        else if(player == "Computer") {
            // Will need to be able to change different strategies here
            return new ComputerPlayer(PlayerId, new ComputerStrategy());
        }
        return null;
    }
}
