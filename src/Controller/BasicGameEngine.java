package Controller;

import Model.AbstractPlayer;
import Model.ValidatotInterface;

//Implements basic game engine
public class BasicGameEngine implements GameEngine{

    //Maybe we want a composite and not an aggregation for validation?
    @Override
    public void Engine(AbstractPlayer[] players , ValidatotInterface validate) {
        for (int i = 0; i < players.length ; i ++ ){
            players[i].Move();
        }
    }
}
