package com.lap.controllers;

import com.lap.dao.impl.ProductDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class TableOfProductsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Положим в request список продуктов под именем "products"
        request.setAttribute("products", ProductDaoImpl.getInstance().findAll());

        // на сервере заредиректим наш запрос на jsp-страничку с постами
        request.getRequestDispatcher("pages/products/telephones.jsp").forward(request,response);
    }
}
