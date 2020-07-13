package Model;
import java.util.Scanner;

public class HumanStrategy implements MoveStrategies {
    private boolean Flag = true;

    //Will read an input from keyword
    @Override
    public int DoSomething() {
        int col = -1;
        while (isFlag()) {
            String s = System.console().readLine().trim();
            try {
                col = Integer.parseInt(s);
                setFlag(false);
            } catch (NumberFormatException e) {
                System.out.println("Invalid key!");
                setFlag(true);
            }
        }
        return col;
    }

    public void setFlag ( boolean flag){
            Flag = flag;
    }

    public boolean isFlag() {
        return Flag;
    }
}
