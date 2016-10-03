package com.lap.controllers;

import com.lap.Role;
import com.lap.dao.impl.ProductGroupDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by lapte on 23.08.2016.
 */
public class TableOfProductGroupsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Положим в request список продуктов под именем "productGroups"
        request.setAttribute("productGroups", ProductGroupDaoImpl.getInstance().findAll());


        HttpSession session = request.getSession();
        Role role = (Role) session.getAttribute("userRole");
        if (role == Role.ADMIN) {
            // на сервере заредиректим наш запрос на jsp-страничку с группами товаров
            request.getRequestDispatcher("/pages/productGroups.jsp").forward(request, response);
        }else {
            request.getRequestDispatcher("/pages/registration/registration.jsp").forward(request, response);
        }
    }
}
