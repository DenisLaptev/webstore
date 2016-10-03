package com.lap.controllers;

import com.lap.dao.impl.ProductDaoImpl;
import com.lap.dao.impl.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by lapte on 23.08.2016.
 */
public class RegistrationRequestServlet extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Положим в request список пользователей под именем "users"
        request.setAttribute("users", UserDaoImpl.getInstance().findAll());

        // на сервере заредиректим наш запрос на jsp-страничку с постами
        request.getRequestDispatcher("/pages/registration/registration.jsp").forward(request,response);
    }
}
