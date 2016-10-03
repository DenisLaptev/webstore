package com.lap.dao.impl;

import com.lap.dao.api.ProductGroupDao;
import com.lap.db_util.DataSource;
import com.lap.entity.ProductGroup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ProductGroupDaoImpl implements ProductGroupDao {

    private static final String SELECT_ALL_PRODUCT_GROUPS = "SELECT * FROM productgroups";
    private static final String SELECT_PRODUCT_GROUP_BY_ID = "SELECT * FROM productgroups WHERE id = ?";
    private static final String DELETE_PRODUCT_GROUP_BY_ID = "DELETE  FROM productgroups WHERE id = ?";
    private static final String CREATE_PRODUCT_GROUP = "INSERT INTO productgroups (`shortName`, `description`) VALUES (?, ?)";


    // Создали синглтон для соединения с БД.
    // далее в методах мы будем к нему обращаться.
    private DataSource dataSource;
    private ProductGroupDaoImpl() {
        dataSource = DataSource.getInstance();
    }

    private static ProductGroupDao productGroupDao;

    public static ProductGroupDao getInstance() {
        if (productGroupDao == null) {
            synchronized (ProductGroupDaoImpl.class) {
                if (productGroupDao == null) {
                    productGroupDao = new ProductGroupDaoImpl();
                }
            }
        }
        return productGroupDao;
    }


    @Override
    public List<ProductGroup> findAll() {
        Connection connection = dataSource.getConnection();
        List<ProductGroup> productGroups = new LinkedList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_ALL_PRODUCT_GROUPS);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {

                ProductGroup productGroup = new ProductGroup();

                productGroup.setId(resultSet.getLong("id"));
                productGroup.setShortName(resultSet.getString("shortName"));
                productGroup.setDescription(resultSet.getString("description"));

                productGroups.add(productGroup);
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
        return productGroups;
    }

    @Override
    public ProductGroup findById(long id) {
        Connection connection = dataSource.getConnection();
        ProductGroup productGroup = new ProductGroup();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_GROUP_BY_ID);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                productGroup.setId(resultSet.getLong("id"));
                productGroup.setShortName(resultSet.getString("shortName"));
                productGroup.setDescription(resultSet.getString("description"));
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

        return productGroup;
    }

    @Override
    public void delete(long id) {
        Connection connection = dataSource.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCT_GROUP_BY_ID);
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
    public boolean create(ProductGroup productGroup) {
        boolean isCreate = false;
        /*
        поля класса ProductGroup:

        private Long id;
        private String shortName;
        private String description;
        private List<Product> products;
        */
        Connection connection = dataSource.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_PRODUCT_GROUP);

            preparedStatement.setString(1, productGroup.getShortName());
            preparedStatement.setString(2, productGroup.getDescription());


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
}
