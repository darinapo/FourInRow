package Java.Connections;

import Java.Controller.GameManager;
import Java.Model.Board;
import Java.Model.GameMenu;
import Java.Model.GameState;
import Java.Model.GameUtilites;
import Java.Observer.Observer;
import Java.Utils.GameProperties;

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



    public void connectGame(){
        System.out.println("Welcome to Four in a Line!");
        List<String> gameMenu = GameMenu.getInitGameMenu();
        printMenu(gameMenu);
        try{
            int choice = Integer.parseInt(terminalInput.nextLine());
            initGame(choice);
        }
        catch (NumberFormatException e){
            printErrorMessage(GameProperties.getPropertyValue("103"));
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            connectGame();
        }
    }

    private void printMenu(List<String> gameMenu) {
        for(String menuItem: gameMenu){
            System.out.println(menuItem);
        }
        System.out.print("Please choose an option:");
    }

    public void initGame(int gameModeInt) throws Exception {
        gameState = GameManager.getInstance().createNewGame(gameModeInt);
        gameState.attach(this);
        update();
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
        try {
            int colIndex = Integer.parseInt(terminalInput.nextLine()); // no exception handling...
            colIndex--;
            setPlayerMove(colIndex);
        } catch (NumberFormatException e) {
            printErrorMessage(GameProperties.getPropertyValue("103"));
        }
    }

    private void printWinner(int currentPlayer) {
        System.out.print("Player " + currentPlayer + " Wins!!!!");
    }

    private void setPlayerMove(int colIndex) {
        try {
            GameManager.getInstance().setPlayerMove(gameState.getGameId(), colIndex);
        } catch (Exception e) {
            printErrorMessage(e.getMessage());
            printWhosNextTurn(gameState.getCurrentPlayer());
        }
    }

    private void printErrorMessage(String errorMsg) {
        System.out.println(errorMsg);
        System.out.println();
    }

    private void printBoard(Board board) {
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
