package Tests.Strategy.Level;

import Java.Model.Mode.GameLevel;
import Java.Strategy.Level.EasyStrategy;
import Java.Strategy.Level.LevelStrategyFactory;
import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LevelStrategyFactoryTest {

    @Rule
    LevelStrategyFactory factory= new LevelStrategyFactory();
    EasyStrategy easyStrategy = new EasyStrategy();
    int hard = 2;
    @Test
    void getLevelStrategy() {
        Assertions.assertNotEquals(easyStrategy.getClass(), factory.getLevelStrategy(hard).getClass());
    }
}