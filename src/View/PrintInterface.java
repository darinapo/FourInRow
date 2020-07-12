package View;

import Model.Board;

public interface PrintInterface {
    public void print(Board board);
    public void print(String str); //to support strings
}
