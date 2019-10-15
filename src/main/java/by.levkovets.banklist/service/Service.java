package by.levkovets.banklist.service;

import by.levkovets.banklist.model.Entity;

import java.util.List;

public interface Service<T extends Entity> {
    void save(T obj);

    void update(T obj);

    void delete(T obj);

    T findById(Integer id);

    List<T> findAll();

}
