package Java.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class GameProperties {

    private static Properties prop;

    static{
        try {
            prop = new Properties();
            prop.load(new FileInputStream(new File("resources/game.properties").getAbsolutePath()));
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

