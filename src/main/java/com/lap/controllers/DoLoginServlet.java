package com.lap.controllers;

import com.lap.dao.impl.UserDaoImpl;
import com.lap.entity.User;
import com.lap.registration_and_login_tests.TestLoginClass;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by lapte on 23.08.2016.
 */
public class DoLoginServlet extends HttpServlet {
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

        //Достаём логин и пароль, которые мы ввели в регистрационной форме.
        String testuserlogin = request.getParameter("UserLogin");
        String testuserpassword = request.getParameter("UserPassword");
        //Создаём объект диспетчера запросов.
        RequestDispatcher rd = null;

        //Создаём объект класса TestLoginClass и вызываем на нём метод
        //testLoginMethod() для того, чтобы проверить, были ли уже
        //такие логин и пароль.
        TestLoginClass testLogin = new TestLoginClass();
        String result = testLogin.testLoginMethod(testuserlogin, testuserpassword);



        if (result.equals("success")) {
            // если в БД есть пользователь с указанными
            // в логин-форме логином и паролем ("success"),
            // то логинивание успешно.


            //создаём экземпляр класса User,
            //ищем в БД юзера по логину с помощью метода findByLogin(String login)
            //и записываем в новый объект.
            //В результате, получем пользователя из БД.

            User user = UserDaoImpl.getInstance().findByLogin(testuserlogin);



            //Данные две строчки создают сессию под успешно залогинившегося юзера.
            HttpSession session = request.getSession();
            session.setAttribute("userLogin", user.getLogin());
            session.setAttribute("userRole", user.getRole());
            session.setAttribute("user", user);


            //Диспетчер запросов перенаправляет нас
            //на jsp-страницу успешного логинивания.
            rd = request.getRequestDispatcher("/pages/login/successLogin.jsp");
            //у запроса есть атрибут "user", он нам нужен, чтоб
            //обратиться к прользователю по имени.
            request.setAttribute("user", user);

        } else {
            //В случае, если в БД нет пользователя
            //с указанными в логин-форме логином и паролем,
            //диспетчер запросов перенаправляет нас
            //на jsp-страницу неуспешного логинивания.
            rd = request.getRequestDispatcher("/pages/login/failedLogin.jsp");
        }
        rd.forward(request, response);
    }
}
