package Model.Player;

//Maybe abstract factory?
public class PlayerFactory {

    public AbstractPlayer getPlayer(PlayerEnum player, int playerId){
        if(player.equals(PlayerEnum.Human)) {
            return new HumanPlayer(playerId, "Player " + playerId/*, new HumanStrategy()*/);
        }
        else if(player.equals(PlayerEnum.Computer)) {
            // Will need to be able to change different strategies here
            return new ComputerPlayer(playerId, PlayerEnum.Computer.name() +" " + playerId/*, new ComputerStrategy()*/);
        }
        return null;
    }
}
