package Java.Dao;

import java.util.Collection;
import java.util.Optional;

public interface Dao<T> {

        Optional<T> get(Long id);

        Collection<T> getAll();

        void save(T t);

        void update(T t, String[] params);

        void delete(T t);

        Long getNextFreeGameId();
}
