package Java;

import Java.Connections.TerminalConnection;
import Java.Controller.GameManager;
import Java.Dao.RamGameDao;
import Java.Exceptions.QuitKeyInserted;

public class Main {
    public static void main(String[] args) {

        try {
            GameManager gameManager = GameManager.getInstance();
            gameManager.getGameProxyDao().setCurrentDao(new RamGameDao());
            TerminalConnection terminalConnection = new TerminalConnection();
            terminalConnection.connectGame();
        }
        catch(QuitKeyInserted quitKeyInserted){
            System.out.println("Exit game key was pressed.. Bye Bye");
            return;
        }
    }
}
