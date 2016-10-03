package com.lap.PropertiesFiles;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by lapte on 19.07.2016.
 */
public class ReadPropertiesFile {
    // минусом класса Properties является то, что нельзя задавать кодировку для чтения.
    // и могут возникнуть проблемы с русскими словами.
    // Выход есть. Если хотим сохранить что-то на русском языке, надо
    // это хранить, как юникод-последовательность. Исп. онлайн юникод-конвертер.
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\main\\resources\\db.properties"));
        //properties.load(new FileInputStream("C:\Users\lapte\IdeaProjects\webstore\src\main\resources\db.properties"));

        System.out.println("driver_class is: " + properties.get("driver_class"));
        System.out.println("jdbc_url is: " + properties.get("jdbc_url"));
        System.out.println("user_of_db is: " + properties.get("user_of_db"));
        System.out.println("password_of_db is: " + properties.get("password_of_db"));

    }
}
