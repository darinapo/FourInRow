package Model;

public abstract class AbstractPlayer
{
    private int Id;
    private String Color;
    private int Score = 0;//Always start from 0
    private MoveStrategies Strategy;

    //---------------------Private Methods----------------------------------


    //---------------------Public Methods-----------------------------------
    //Constructor
    public AbstractPlayer(int id, MoveStrategies strategy){
        Id=id;
        Strategy = strategy;
    }
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color){
        Color = color;
    }

    public int getScore(){
        return Score;
    }

    public void IncreaseCount(){
        Score++;
    }

    public MoveStrategies getStrategy(){ return Strategy;}

    abstract public int Move();

}
