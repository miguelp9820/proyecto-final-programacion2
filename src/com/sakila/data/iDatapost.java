package com.sakila.data;

import java.util.List;

public interface iDatapost<T> {
    void save(T obj);        // POST
    void update(T obj);      // PUT
    void delete(int id);     // DELETE
    T getById(int id);       // GET by ID
    List<T> getAll();        // GET all records

}
