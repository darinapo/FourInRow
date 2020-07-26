import Connections.TerminalConnection;
import Controller.Game;
import Controller.GameManager;
import Dao.RamGameDao;
import Utils.GameProperties;

public class Main {

    public static void main(String[] args){

        GameProperties.getPropertyValue("101");
        GameManager gameManager = GameManager.getInstance();
        gameManager.getGameProxyDao().setCurrentDao(new RamGameDao());
        TerminalConnection terminalConnection = new TerminalConnection();
        terminalConnection.connectGame();

//        return;
    }
}
