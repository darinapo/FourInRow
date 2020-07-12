package Controller;

public abstract class GameTemplate {
    abstract void Initialize();
    abstract void StartPlay();
    abstract void EndPlay();
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
