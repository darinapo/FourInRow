package Model;
//Maybe a singeltone?
public class PlayerFactory {

    private int PlayerId = 0; //default value
    public AbstractPlayer GetPlayer(String player){
        PlayerId++;
        if(player == "human")
            return new HumanPlayer(PlayerId);
        else if(player == "Computer")
            return new ComputerPlayer(PlayerId);
        return null;
    }
}
