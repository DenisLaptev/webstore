package com.lap.PropertiesFiles;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by lapte on 19.07.2016.
 */
public class CreatePropertiesFile {
    // Класс создаёт .properties-файл ("db.properties").
    public static void main(String[] args) {

        Properties properties = new Properties();

        properties.put("driver_class", "com.mysql.jdbc.Driver");
        properties.put("jdbc_url", "jdbc:mysql://localhost:3306/webstore?serverTimezone=UTC");
        properties.put("user_of_db", "root");
        properties.put("password_of_db", "root");

        try {
            properties.store(new FileOutputStream("src\\main\\resources\\db.properties"),"comment DataBase");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
