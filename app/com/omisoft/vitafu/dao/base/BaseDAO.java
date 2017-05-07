package com.omisoft.vitafu.dao.base;

import com.omisoft.vitafu.entity.BaseEntity;
import com.omisoft.vitafu.entity.Genres;

import java.util.Collection;
import java.util.List;

/**
 * BaseDAO class
 * Created by dido on 10/16/14.
 */
public interface BaseDAO<T extends BaseEntity> {
    /**
     * Finds all elements
     *
     * @return
     */
    public List<T> findAll();

    /**
     * Deletes by id
     *
     * @param id   id
     */
    public void deleteByID(final Long id);

    /**
     * Updates entity
     *
     * @param t tyoe
     * @return updated entity
     */
    public T update(T t);


    /**
     * Finds by ID one element
     *
     * @return entity
     */
    public T findByID(final Long id);

    /**
     * Saves or updates an entity
     * @param t extends {@link com.omisoft.vitafu.entity.BaseEntity}
     * @return the saved entity
     */
    public T save(T t);

    /**
     * Saves all entities from collection
     * @param collection
     */
    public void saveAll(Collection<T>  collection);

    /**
     * Selects all movies from the database
     * @return - list of all movies
     */
    public List<T> selectMoviesFromDB();


}
