package Model;

public abstract class AbstractPlayer
{
    private int Id;
    private String Color;
    private int Score = 0;//Always start from 0

    //---------------------Private Methods----------------------------------


    //---------------------Public Methods-----------------------------------
    public AbstractPlayer(int id){ Id=id;}
    abstract public int Move();
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
    };
    public int getScore(){
        return Score;
    }
    public void IncreaseCount(){
        Score++;
    }
}
