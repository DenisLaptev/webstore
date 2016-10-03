package com.lap.controllers;

import com.lap.dao.impl.UserDaoImpl;
import com.lap.entity.User;
import com.lap.registration_and_login_tests.TestRegistrationClass;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by lapte on 23.08.2016.
 */
public class DoRegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*
        Поля класса User:

        private Long id;
        private String name;
        private String secondName;
        private int age;
        private String email;
        private String login;
        private String password;
        */

        //Достаём логин, который мы ввели в регистрационной форме.
        String testuserlogin = request.getParameter("UserLogin");
        //Создаём объект диспетчера запросов.
        RequestDispatcher rd = null;

        //Создаём объект класса TestRegistrationClass и вызываем на нём метод
        //testRegistrationMethod() для того, чтобы проверить, был ли уже
        //такой логин.
        TestRegistrationClass testRegistration = new TestRegistrationClass();
        String result = testRegistration.testRegistrationMethod(testuserlogin);



        if (result.equals("unknown")) {
            // если логин не известный ("unknown"),
            // то регистрация успешна, и мы создаём такого
            // пользователя.


            //Достаём то, что было введено в регистрационной форме,
            //даём конструктору и создаём экземпляр класса User
            //с введёнными данными.

            /*Long UidField = Long.parseLong(request.getParameter("UserId"));*/
            String UnameField = request.getParameter("UserName");
            String UsecondNameField = request.getParameter("UserSecondName");
            int age = Integer.parseInt(request.getParameter("UserAge"));
            String email = request.getParameter("UserEmail");
            String login = request.getParameter("UserLogin");
            String password = request.getParameter("UserPassword");

            User user = new User(
                    UnameField,
                    UsecondNameField,
                    age,
                    email,
                    login,
                    password);

            // Обращаемся к БД и создаём нового пользователя.
            UserDaoImpl.getInstance().create(user);

            //Диспетчер запросов перенаправляет нас
            // на jsp-страницу успешной регистрации.
            rd = request.getRequestDispatcher("/pages/registration/successRegistration.jsp");
            //у запроса есть атрибут "user", он нам нужен, чтоб
            //обратиться к прользователю по имени.
            request.setAttribute("user", user);
        } else {
            //В случае, если логин известен ("known"), т.е. не равен "unknown",
            //диспетчер запросов перенаправляет нас
            //на jsp-страницу неуспешной регистрации.
            rd = request.getRequestDispatcher("/pages/registration/failedRegistration.jsp");
        }
        rd.forward(request, response);
    }
}
