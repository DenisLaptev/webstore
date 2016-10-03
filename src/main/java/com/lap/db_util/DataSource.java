package com.lap.db_util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

public class DataSource {
    //мы сами придумали назвать класс, как DataSource.

    private static DataSource dataSource;

    private DataSource() {
    }

    public static DataSource getInstance() {
        if (dataSource == null) {
            synchronized (DataSource.class) {
                if (dataSource == null) {
                    dataSource = new DataSource();
                }
            }
        }
        return dataSource;
    }

    public Connection getConnection() {
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        //В качестве pool-а connection-ов выступает
        // класс ComboPooledDataSource
        Connection conn = null;
        try {
/*
            //Задаём значения полей вручную, а не из файла .properties

            cpds.setDriverClass("com.mysql.jdbc.Driver"); //loads the jdbc driver
            cpds.setJdbcUrl("jdbc:mysql://localhost:3306/webstore?serverTimezone=UTC");
            cpds.setUser("root");
            cpds.setPassword("root");
*/

            //Задаём значения полей с помощью файла .propertiesMySQL - webstore@localhost

            Properties properties = new Properties();
            properties.load(new FileInputStream("C:\\Users\\lapte\\IdeaProjects\\webstore\\src\\main\\resources\\db.properties"));
            //properties.load(new FileInputStream("src\\main\\resources\\db.properties"));//не понимает

            cpds.setDriverClass(String.valueOf(properties.get("driver_class"))); //loads the jdbc driver
            cpds.setJdbcUrl(String.valueOf(properties.get("jdbc_url")));
            cpds.setUser(String.valueOf(properties.get("user_of_db")));
            cpds.setPassword(String.valueOf(properties.get("password_of_db")));

            /*
            System.out.println(String.valueOf(properties.get("driver_class")));
            System.out.println(String.valueOf(properties.get("jdbc_url")));
            System.out.println(String.valueOf(properties.get("user_of_db")));
            System.out.println(String.valueOf(properties.get("password_of_db")));

            */
            //Задали значения полей с помощью файла .properties

            cpds.setMinPoolSize(5);
            cpds.setAcquireIncrement(5);
            cpds.setMaxPoolSize(50);

            conn = cpds.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }
}
