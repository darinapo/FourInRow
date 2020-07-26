package Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GameProperties {

    private static Properties prop;

    static{
        try {
            prop = new Properties();
            prop.load(new FileInputStream("/Users/yonigotliv/Work/M.B.A/CodingProjects/FourInRow/src/Utils/game.properties"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getPropertyValue(String key){
        return prop.getProperty(key);
    }
}
