package com.lap.dao.impl;

import com.lap.dao.api.ProductDao;
import com.lap.db_util.DataSource;
import com.lap.entity.Product;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {

    private static final String SELECT_ALL_PRODUCTS = "SELECT * FROM computers";
    private static final String SELECT_PRODUCT_BY_ID = "SELECT  FROM computers WHERE id = ?";
    private static final String DELETE_PRODUCT_BY_ID = "DELETE  FROM computers WHERE id = ?";
    private static final String CREATE_PRODUCT = "INSERT INTO computers VALUES (?, ?, ?, ?, ?)";

    // Создали синглтон для соединения с БД.
    // далее в методах мы будем к нему обращаться.
    private DataSource dataSource;
    private ProductDaoImpl() {
        dataSource = DataSource.getInstance();
    }

    private static ProductDao productDao;
    public static ProductDao getInstance() {
        if (productDao == null) {
            synchronized (ProductDaoImpl.class) {
                if (productDao == null) {
                    productDao = new ProductDaoImpl();
                }
            }
        }
        return productDao;
    }


    @Override
    public List<Product> findAll() {
        Connection connection = dataSource.getConnection();
        List<Product> products = new LinkedList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_ALL_PRODUCTS);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {

                Product product = new Product();
                product.setId(resultSet.getLong("id"));
                product.setShortName(resultSet.getString("shortName"));
                product.setDescription(resultSet.getString("description"));
                product.setCount(resultSet.getInt("count"));
                product.setPrice(resultSet.getDouble("price"));

                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return products;
    }

    @Override
    public Product findById(long id) {
        Connection connection = dataSource.getConnection();
        Product product = new Product();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_ID);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();


            product.setId(resultSet.getLong("id"));
            product.setShortName(resultSet.getString("shortName"));
            product.setDescription(resultSet.getString("description"));
            product.setCount(resultSet.getInt("count"));
            product.setPrice(resultSet.getDouble("price"));

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return product;
    }

    @Override
    public void delete(long id) {
        Connection connection = dataSource.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCT_BY_ID);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean create(Product product) {
        boolean isCreate = false;
        /*
        поля класса Product:

        private Long id;
        private String shortName;
        private String description;
        private int count;
        private double price;
        */
        Connection connection = dataSource.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_PRODUCT);

            preparedStatement.setLong(1, product.getId());
            preparedStatement.setString(2, product.getShortName());
            preparedStatement.setString(3, product.getDescription());
            preparedStatement.setInt(4, product.getCount());
            preparedStatement.setDouble(5, product.getPrice());

            preparedStatement.executeUpdate();
            isCreate = true;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return isCreate;
    }

    @Override
    public boolean edit(Product product) {
        return false;
    }

    @Override
    public boolean decrease(long id, int count) {
        return false;
    }
}
