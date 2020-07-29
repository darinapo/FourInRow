package Tests.Dao;

import Java.Controller.Game;
import Java.Dao.RamGameDao;
import Java.Model.Mode.GameMode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RamGameDaoTest {

    @Test
    void get() {
        Game game = new Game(GameMode.PlayerVsPlayer,(long)1);
        RamGameDao ramGameDao  = new RamGameDao();
        ramGameDao.save(game);
        Assertions.assertEquals(game, ramGameDao.get((long)1).get());
    }

    @Test
    void save() {
        Game game = new Game(GameMode.PlayerVsPlayer,(long)1);
        RamGameDao ramGameDao  = new RamGameDao();
        ramGameDao.save(game);
        Assertions.assertEquals(game, ramGameDao.get((long)1).get());
    }

    @Test
    void update(){
        Game game = new Game(GameMode.PlayerVsPlayer,(long)1);
        RamGameDao ramGameDao  = new RamGameDao();
        ramGameDao.save(game);
        Game game2 = new Game(GameMode.PlayerVsPlayer,(long)2);
        //ramGameDao.update();

    }

    @Test
    void delete() {
        Game game = new Game(GameMode.PlayerVsPlayer,(long)1);
        RamGameDao ramGameDao  = new RamGameDao();
        ramGameDao.save(game);
        ramGameDao.delete(game);
        Assertions.assertTrue(ramGameDao.get((long)1).isEmpty());
    }

    @Test
    void getNextFreeGameId() {
        Game game = new Game(GameMode.PlayerVsPlayer,(long)1);
        RamGameDao ramGameDao  = new RamGameDao();
        ramGameDao.save(game);
        Assertions.assertEquals(2, ramGameDao.getNextFreeGameId());
    }
}