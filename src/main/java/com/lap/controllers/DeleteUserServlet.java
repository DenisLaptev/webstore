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
 * Created by lapte on 17.08.2016.
 */
public class DeleteUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        UserDaoImpl.getInstance().delete(id);
        /*После удаления возвращаемся обратно на данную страницу.*/
        response.sendRedirect("/usersServlet");
    }
}
