package Java.Model;

public class HumanStrategy implements MoveStrategies {
    private boolean Flag = true;

    //Will read an input from keyword
    @Override
    public int chooseMove() {
        int col = -1;
        while (isFlag()) {
            String s = System.console().readLine();
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
