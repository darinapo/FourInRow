package Java;

import Java.Connections.TerminalConnection;
import Java.Controller.GameManager;
import Java.Dao.RamGameDao;

public class Main {

    public static void main(String[] args){

        GameManager gameManager = GameManager.getInstance();
        gameManager.getGameProxyDao().setCurrentDao(new RamGameDao());
        TerminalConnection terminalConnection = new TerminalConnection();
        terminalConnection.connectGame();

//        return;
    }
}
