package by.levkovets.banklist.dao;

import by.levkovets.banklist.domain.Entity;
import java.util.List;

public interface Dao<T extends Entity> {

    void save(T obj);

    void update(T obj);

    void delete(T obj);

    T findById(Integer id);

    List<T> findAll();
}
