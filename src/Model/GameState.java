package Model;

import Model.Mode.GameMode;
import Model.Player.AbstractPlayer;
import Observer.Observer;
import View.ProxyViewer;

import java.util.ArrayList;
import java.util.List;

public class GameState {
    private Board board = null;
    private ArrayList<AbstractPlayer> players = null;
    private int currentPlayer = -1; //Our IDs starts from 1
    private int winner = -1;
    private Long gameId;
    private GameMode gameMode;
    private List<Observer> observers = new ArrayList<Observer>();
//    private ProxyViewer proxyViewer;

    public GameState(Long gameId, GameMode gameMode/*, ProxyViewer proxyViewer*/) {
        this.gameId = gameId;
        this.gameMode = gameMode;
        players = new ArrayList<AbstractPlayer>();
//        this.proxyViewer = proxyViewer;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public ArrayList<AbstractPlayer> getPlayers() {
        return players;
    }

    public void addPlayer(AbstractPlayer player) {
        this.players = players;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(int currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public int getWinner() {
        return winner;
    }

    public void setWinner(int winner) {
        this.winner = winner;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public GameMode getGameMode() {
        return gameMode;
    }

    public void setGameMode(GameMode gameMode) {
        this.gameMode = gameMode;
    }

    private void notifyStateChanged() {
        for(Observer observer: observers) {
            observer.update();
        }
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }
}
