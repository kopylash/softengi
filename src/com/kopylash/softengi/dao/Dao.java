package com.kopylash.softengi.dao;

import java.util.List;

/**
 * Created by Владислав on 08.09.2015.
 */

public interface Dao<T, I>
{

    List<T> findAll();


    T find(I id);


    T save(T newsEntry);

    T insert(T newsEntry);


    void delete(I id);

}
