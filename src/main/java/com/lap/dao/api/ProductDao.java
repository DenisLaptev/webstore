package com.lap.dao.api;

import com.lap.entity.Product;

import java.util.List;


public interface ProductDao {
    List<Product> findAll();

    Product findById(long id);

    void delete(long id);

    boolean create(Product product);

    boolean edit(Product product);

    boolean decrease(long id, int count);
}
