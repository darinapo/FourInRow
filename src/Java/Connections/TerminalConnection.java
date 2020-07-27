package Java.Connections;

import Java.Controller.GameManager;
import Java.Exceptions.NotValidGameModeException;
import Java.Exceptions.QuitKeyInserted;
import Java.Model.Board;
import Java.Model.GameMenu;
import Java.Model.GameState;
import Java.Model.Mode.GameMode;
import Java.Observer.Observer;
import java.util.List;
import java.util.Scanner;

public class TerminalConnection implements Observer {
    private GameState gameState;
    Scanner terminalInput;
    public static char XPLAYER = 'X';
    public static char OPLAYER = 'O';
    public static char EMPTY = ' ';

    public TerminalConnection() {
        terminalInput = new Scanner(System.in);
    }



    public void connectGame() throws QuitKeyInserted{
        System.out.println("Welcome to Four in a Line!");
        List<String> gameMenu = GameMenu.getInitGameMenu();
        printMenu(gameMenu);
        int choice;
        try{
            choice = Integer.parseInt(terminalInput.nextLine()); // no exception handling...5
            if(choice == GameMode.values().length-1){
                throw new QuitKeyInserted("Key number 3 was pressed..");
            }

            try{
                initGame(choice);
            }
            catch (NotValidGameModeException e){
                System.out.println("Not valid Game Mode..please choose again from the menu");

            }
            finally {
                connectGame();
            }
        }

        catch (QuitKeyInserted quitKeyInserted){
            System.out.println("Quitting game.. Bye Bye");
            throw new QuitKeyInserted(quitKeyInserted.getMessage());
        }
    }

    private void printMenu(List<String> gameMenu) {
        for(String menuItem: gameMenu){
            System.out.println(menuItem);
        }
        System.out.print("Please choose an option:");
    }

    public void initGame(int gameModeInt) throws NotValidGameModeException {
        try {
            gameState = GameManager.getInstance().createNewGame(gameModeInt);
            gameState.attach(this);
            update();
        } catch (NotValidGameModeException quitKeyInserted) {
            quitKeyInserted.printStackTrace();
            throw new NotValidGameModeException(quitKeyInserted.getMessage());
        }
    }

    @Override
    public void update() {
        printBoard(gameState.getBoard());
        if (gameState.getWinner()) {
            printWinner(gameState.getCurrentPlayer());
        } else {
            printWhosNextTurn(gameState.getCurrentPlayer());
        }
    }

    private void printWhosNextTurn(int currentPlayer) {
        System.out.print("Player " + currentPlayer + ", choose a column: ");
        int colIndex = Integer.parseInt(terminalInput.nextLine()); // no exception handling...
        colIndex--;
        setPlayerMove(colIndex);
    }

    private void printWinner(int currentPlayer) {
        System.out.print("Player " + currentPlayer + " Wins!!!!");
    }

    private void setPlayerMove(int colIndex) {
        try {
            GameManager.getInstance().setPlayerMove(gameState.getGameId(), colIndex);
        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println(e.getMessage());
            System.out.println();
            printWhosNextTurn(gameState.getCurrentPlayer());
        }

    }

    private void printBoard(Board board) {
        System.out.println("Printing board:");
        System.out.println();
        for (int j = 0; j < board.getRowSize(); j++) {
            System.out.print("|");
            for (int k = 0; k < board.getColumnSize(); k++) {
                char discToPrint;
                switch (board.getDiscAtBoard(j, k)) {
                    case 0: discToPrint = EMPTY; break;
                    case 1: discToPrint = OPLAYER; break;
                    case 2: discToPrint = XPLAYER; break;
                    default:
                        discToPrint = EMPTY;
//                        throw new IllegalStateException("Unexpected value: " + board.getDiscAtBoard(j, k));
                }
                System.out.print(discToPrint + "|");
            }
            System.out.println();
        }
        for (int k = 0; k < 2*board.getColumnSize()+1; k++)
            System.out.print("-");
        System.out.println();
        System.out.println();
    }
}
