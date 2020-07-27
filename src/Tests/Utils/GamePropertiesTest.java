package Tests.Utils;

import Java.Controller.Game;
import Java.Utils.GameProperties;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GamePropertiesTest {

    @Test
    void getPropertyValue() {
        String str = null;
        str = GameProperties.getPropertyValue("101");
        Assertions.assertNotEquals(str,null);
        str = GameProperties.getPropertyValue("104");
        Assertions.assertEquals(str,null);
    }

}