package Dao;

import Controller.Game;

import java.util.Collection;
import java.util.Optional;

public class GameProxyDao implements Dao<Game> {

    RamGameDao ramGameDao;

    public GameProxyDao() {
        this.ramGameDao = new RamGameDao();
    }

    @Override
    public Optional<Game> get(Long id) {
        return ramGameDao.get(id);
    }

    @Override
    public Collection<Game> getAll() {
        return ramGameDao.getAll();
    }

    @Override
    public void save(Game game) {
        ramGameDao.save(game);
    }

    @Override
    public void update(Game game, String[] params) {
        ramGameDao.update(game, params);
    }

    @Override
    public void delete(Game game) {
        ramGameDao.delete(game);
    }

    @Override
    public Long getNextFreeGameId() {
        return null;
    }
}
