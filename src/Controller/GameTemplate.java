package Controller;

public abstract class GameTemplate {
    abstract public void Initialize();
    abstract public void StartPlay();
    abstract public void EndPlay();
    //template method
    public final void Play(){

        //initialize the game
        Initialize();

        //start game
        StartPlay();

        //end game
        EndPlay();
    }
}
