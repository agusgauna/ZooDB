package ar.com.ada.maven.root.model.dao;

import java.util.Collection;

public interface Dao<T> {

    Collection<T> findAll();

    T findById(Integer id);

    boolean save(T t);

    boolean update(T t, Integer id);

    Boolean delete(Integer id);
}
