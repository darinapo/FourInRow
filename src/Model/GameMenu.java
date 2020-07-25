package Model;

import java.util.ArrayList;
import java.util.List;

public class GameMenu {

    // the main menu
    public static char PlayVsComputer = '0';
    public static char PlayVsPlayer = '1';
    public static char ComputerVsCompouter = '2';
    public static char QUIT = '3';
    public static List<String> initGameMenu = new ArrayList<String>();
    static {
        initGameMenu.add(PlayVsComputer + ". Play against computer");
        initGameMenu.add(PlayVsPlayer + ". Play against a friend");
        initGameMenu.add(ComputerVsCompouter + ". Watch Computer plays Computer");
        initGameMenu.add(QUIT + ". Quit");
    }

    public static List<String> getInitGameMenu() {
        return initGameMenu;
    }
}
