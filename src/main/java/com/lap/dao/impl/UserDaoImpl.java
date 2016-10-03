package com.lap.dao.impl;

import com.lap.dao.api.UserDao;
import com.lap.db_util.DataSource;
import com.lap.entity.User;
import com.lap.helper.TransformerRole;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private static final String SELECT_ALL_USERS = "SELECT * FROM users";
    private static final String SELECT_USER_BY_ID = "SELECT * FROM users WHERE id = ?";
    private static final String DELETE_USER_BY_ID = "DELETE * FROM users WHERE id = ?";
    private static final String CREATE_USER = "INSERT INTO users (`name`, `secondName`, `age`, `email`, `login`, `password`, `role`) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String FIND_BY_LOGIN = "SELECT * FROM users WHERE login = ?";
    private static final String FIND_BY_LOGIN_AND_PASSWORD = "SELECT * FROM users WHERE login = ? AND password = ?";

    // Создали синглтон для соединения с БД.
    // далее в методах мы будем к нему обращаться.
    private DataSource dataSource;

    private UserDaoImpl() {
        dataSource = DataSource.getInstance();
    }

    private static UserDao userDao;

    public static UserDao getInstance() {
        if (userDao == null) {
            synchronized (UserDaoImpl.class) {
                if (userDao == null) {
                    userDao = new UserDaoImpl();
                }
            }
        }
        return userDao;
    }


    @Override
    public List<User> findAll() {
        Connection connection = dataSource.getConnection();
        List<User> users = new LinkedList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_ALL_USERS);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {

                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setSecondName(resultSet.getString("secondName"));
                user.setAge(resultSet.getInt("age"));
                user.setEmail(resultSet.getString("email"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));

                // считываем с БД строку "0" или "1",
                // преобразуем в тип Role и передаём новому объекту user в соответствующее поле.
                user.setRole(TransformerRole.transformRoleSqlToRole(resultSet.getString("role")));

                users.add(user);
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
        return users;
    }


    @Override
    public User findById(long id) {
        Connection connection = dataSource.getConnection();
        User user = new User();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setSecondName(resultSet.getString("secondName"));
                user.setAge(resultSet.getInt("age"));
                user.setEmail(resultSet.getString("email"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                // считываем с БД строку "0" или "1",
                // преобразуем в тип Role и передаём новому объекту user в соответствующее поле.
                user.setRole(TransformerRole.transformRoleSqlToRole(resultSet.getString("role")));


                //user.setRole((Role) resultSet.getObject("role"));
                // Мы сделали приведение типов.
                // От типа Object к типу Role.
            /*В видеолекциях (ПЗ № 8, 7:21):
            user.setRole(DaoFactory.getInstance().getRoleDao().getById(resultSet.getInt("role id")));
             */

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

        return user;
    }

    @Override
    public void delete(long id) {
        Connection connection = dataSource.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER_BY_ID);
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
    public boolean create(User user) {
        boolean isCreate = false;
        /*
        поля класса User:

        private Long id;
        private String name;
        private String secondName;
        private int age;
        private String email;
        private String login;
        private String password;
        private Role role;
        private List<Product> listOfUserProducts = new ArrayList<>();
        */
        Connection connection = dataSource.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_USER);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSecondName());
            preparedStatement.setInt(3, user.getAge());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getLogin());
            preparedStatement.setString(6, user.getPassword());
            preparedStatement.setString(7, "0");
            //preparedStatement.setString(8, String.valueOf(user.getRole())); //правильно

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
    public User findByLogin(String login) {
        Connection connection = dataSource.getConnection();
        User user = new User();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_LOGIN);
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setSecondName(resultSet.getString("secondName"));
                user.setAge(resultSet.getInt("age"));
                user.setEmail(resultSet.getString("email"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                // считываем с БД строку "0" или "1",
                // преобразуем в тип Role и передаём новому объекту user в соответствующее поле.
                user.setRole(TransformerRole.transformRoleSqlToRole(resultSet.getString("role")));

                //user.setRole((Role) resultSet.getObject("role"));
                // Мы сделали приведение типов.
                // От типа Object к типу Role.
            /*В видеолекциях (ПЗ № 8, 7:21):
            user.setRole(DaoFactory.getInstance().getRoleDao().getById(resultSet.getInt("role id")));
             */
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

        return user;
    }


    @Override
    public User findByLoginAndPassword(String login, String password) {
        Connection connection = dataSource.getConnection();
        User user = new User();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_LOGIN_AND_PASSWORD);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setSecondName(resultSet.getString("secondName"));
                user.setAge(resultSet.getInt("age"));
                user.setEmail(resultSet.getString("email"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                // считываем с БД строку "0" или "1",
                // преобразуем в тип Role и передаём новому объекту user в соответствующее поле.
                user.setRole(TransformerRole.transformRoleSqlToRole(resultSet.getString("role")));

                //user.setRole((Role) resultSet.getObject("role"));
                // Мы сделали приведение типов.
                // От типа Object к типу Role.
            /*В видеолекциях (ПЗ № 8, 7:21):
            user.setRole(DaoFactory.getInstance().getRoleDao().getById(resultSet.getInt("role id")));
             */
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

        return user;
    }
}
