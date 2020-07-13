package Controller;

import Model.AbstractPlayer;
import Model.ValidatotInterface;

public interface GameEngine {
    void Engine(AbstractPlayer[] players, ValidatotInterface validate);
}
