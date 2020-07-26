package Java.Dao;

import Java.Controller.Game;

import java.util.Collection;
import java.util.Optional;

public class GameProxyDao implements Dao<Game> {

    Dao currentDao;

    public GameProxyDao() {

    }

    public Dao getCurrentDao() {
        return currentDao;
    }

    public void setCurrentDao(Dao currentDao) {
        this.currentDao = currentDao;
    }

    @Override
    public Optional<Game> get(Long id) {
        return currentDao.get(id);
    }

    @Override
    public Collection<Game> getAll() {
        return currentDao.getAll();
    }

    @Override
    public void save(Game game) {
        currentDao.save(game);
    }

    @Override
    public void update(Game game, String[] params) {
        currentDao.update(game, params);
    }

    @Override
    public void delete(Game game) {
        currentDao.delete(game);
    }

    @Override
    public Long getNextFreeGameId() {
        return currentDao.getNextFreeGameId();
    }
}
