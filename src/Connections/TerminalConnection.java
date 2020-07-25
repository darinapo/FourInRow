package Connections;

import Controller.GameManager;
import Model.Board;
import Model.GameMenu;
import Model.GameState;
import Observer.Observer;

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



    public void connectGame() {
        System.out.println("Welcome to Four in a Line!");
        List<String> gameMenu = GameMenu.getInitGameMenu();
        printMenu(gameMenu);
        int choise = Integer.parseInt(terminalInput.nextLine()); // no exception handling...

    }

    private void printMenu(List<String> gameMenu) {
        for(String menuItem: gameMenu){
            System.out.println(menuItem);
        }
        System.out.print("Please choose an option:");
    }

    public void initGame(int gameModeInt) {
        gameState = GameManager.getInstance().createNewGame(gameModeInt);
        gameState.attach(this);
    }

    @Override
    public void update() {
        printBoard(gameState.getBoard());
        printWhosNextTurn(gameState.getCurrentPlayer());
    }

    private void printWhosNextTurn(int currentPlayer) {
        System.out.print("Player " + currentPlayer + ", choose a column: ");
        int col = Integer.parseInt(terminalInput.nextLine()); // no exception handling...
        col--;
    }

    private void printBoard(Board board) {
        System.out.println("Printing board:");
        System.out.println();
        for (int j = 0; j < board.getRowSize(); j++) {
            System.out.print("|");
            for (int k = 0; k < board.getColumnSize(); k++) {
                char discToPrint;
                switch (board.getDiscAtBoard(j, k)) {
                    case 0: discToPrint = EMPTY;
                    case 1: discToPrint = OPLAYER;
                    case 2: discToPrint = XPLAYER;
                        break;
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
