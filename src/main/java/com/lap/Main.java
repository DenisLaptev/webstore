package com.lap;

import com.lap.dao.api.ProductGroupDao;
import com.lap.dao.api.UserDao;
import com.lap.dao.impl.ProductGroupDaoImpl;
import com.lap.dao.impl.UserDaoImpl;
import com.lap.entity.ProductGroup;
import com.lap.entity.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * Created by lapte on 30.08.2016.
 */
public class Main {
    public static void main(String[] args) {


        //Создаём файл "log.txt", в который будем записывать log-и.
        try {
            System.setErr(new PrintStream(new File("log.txt")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }



        UserDao ud = UserDaoImpl.getInstance();
        ProductGroupDao pgd = ProductGroupDaoImpl.getInstance();

        System.out.println("~~~~~~~~~~~~~~Users~~~~~~~~~~~~~~");
        /*
        UserDao methods:

        List<User> findAll();
        User findById(long id);
        void delete(long id);
        boolean create(User user);
        User findByLogin(String login);
        User findByLoginAndPassword(String login, String password);
        */
        System.out.println(".findAll(): " + "\n" + ud.findAll());
        System.out.println();
        System.out.println(".findById(24): " + "\n" + ud.findById(24));
        System.out.println();
        System.out.println(".create(): " + "\n" + ud.create(new User("name1", "secondName1", 25, "email1", "login1", "password1")));
        System.out.println();
        System.out.println(".findByLogin(\"2\"): " + "\n" + ud.findByLogin("2"));
        System.out.println();
        System.out.println(".findByLoginAndPassword(\"2\", \"2\"): " + "\n" + ud.findByLoginAndPassword("2", "2"));
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println("~~~~~~~~~Product Groups~~~~~~~~~~");
        /*
        ProductGroupDao methods:

        List<ProductGroup> findAll();
        ProductGroup findById(long id);
        void delete(long id);
        boolean create(ProductGroup productGroup);
        */
        System.out.println(".findAll(): " + "\n" + pgd.findAll());
        System.out.println();
        System.out.println(".findById(1): " + "\n" + pgd.findById(1));
        System.out.println();
        System.out.println(".create(): " + "\n" + pgd.create(new ProductGroup("pg_shortName", "pg_description")));
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
}
