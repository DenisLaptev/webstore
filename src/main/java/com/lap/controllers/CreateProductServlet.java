package com.lap.controllers;

import com.lap.dao.impl.ProductDaoImpl;
import com.lap.entity.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by lapte on 17.08.2016.
 */
@WebServlet(name = "CreateProductServlet", urlPatterns = "/createProduct")
public class CreateProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long idField = Long.parseLong(request.getParameter("id"));
        String shortNameField = request.getParameter("shortName");
        String descriptionField = request.getParameter("description");
        int countField = Integer.parseInt(request.getParameter("count"));
        double priceField = Double.parseDouble(request.getParameter("price"));
        Product product = new Product(idField,
                shortNameField,
                descriptionField,
                countField,
                priceField);
        // достаём введённый текст по атрибуту name тэга input.
        ProductDaoImpl.getInstance().create(product);
        /*После добавления возвращаемся обратно на данную страницу.*/
        response.sendRedirect("/products");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
