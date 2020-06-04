package org.example.alvin.dao;

import java.util.List;

public interface BaseDao<T> {
    void save(T entity);
    void remove(T entity);
    void update(T entity);
    T load(int id);
    List<T> load(String query);
    List<T> load(String query, Object... params);
}
