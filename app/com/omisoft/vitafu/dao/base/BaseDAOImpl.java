package com.omisoft.vitafu.dao.base;

import com.avaje.ebean.Ebean;
import com.omisoft.vitafu.entity.BaseEntity;
import com.omisoft.vitafu.entity.Genres;
import com.omisoft.vitafu.entity.Movie;

import java.util.Collection;
import java.util.List;

/**
 * Created by dido on 1/5/15.
 */
public class BaseDAOImpl<T extends BaseEntity> implements BaseDAO<T> {

    private Class<T> type;

    public BaseDAOImpl(Class<T> type) {
    this.type=type;
    }

    /**
     * Finds all elements
     *
     * @return
     */
    @Override
    public List<T> findAll() {
        List<T> resultList=Ebean.find(type).findList();
        return resultList;
    }

    /**
     * Deletes by id
     *
     * @param id   id
     */
    @Override
    public void deleteByID(Long id) {
    Ebean.delete(type,id);
    }

    /**
     * Updates entity
     *
     * @param t tyoe
     * @return updated entity
     */
    @Override
    public T update(T t) {
        Ebean.update(t);
        return t;
    }

    /**
     * Finds by ID one element
     *
     * @param id
     * @return entity
     */
    @Override
    public T findByID(Long id) {
        T found = Ebean.find(type,id);
        return found;
    }

    /**
     * Saves or updates an entity
     *
     * @param t extends {@link com.omisoft.vitafu.entity.BaseEntity}
     * @return the saved entity
     */
    @Override
    public T save(T t) {
        Ebean.save(t);
        return t;
    }

    /**
     * Saves all entities from collection
     *
     * @param collection
     */
    @Override
    public void saveAll(Collection<T> collection) {
        Ebean.save(collection);
    }

    /**
     * Selects all movies from the database
     * @return - list of all movies
     */
    @Override
    public List<T> selectMoviesFromDB() {
        List<T> listMoviesDB = Ebean.find(type).findList();
        return listMoviesDB;
    }

}
