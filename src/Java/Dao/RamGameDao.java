package Java.Dao;

import Java.Controller.Game;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class RamGameDao implements Dao<Game> {

    private Map<Long, Game> gameMap;

    public RamGameDao() {
        this.gameMap = new HashMap<Long, Game>();
    }

    @Override
    public Optional<Game> get(Long id) {
        return Optional.ofNullable(gameMap.get(id));
    }

    @Override
    public Collection<Game> getAll() {
        return gameMap.values();
    }

    @Override
    public void save(Game game) {
        gameMap.put(game.getGameId(),game);
    }

    @Override
    public void update(Game game, String[] params) {
        gameMap.replace(game.getGameId(), game);
    }

    @Override
    public void delete(Game game) {
        gameMap.remove(game.getGameId());
    }

    @Override
    public Long getNextFreeGameId() {
        return Long.valueOf(gameMap.size());
    }


}
