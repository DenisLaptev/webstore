package com.lap.controllers;

import com.lap.dao.impl.ProductGroupDaoImpl;
import com.lap.entity.ProductGroup;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by lapte on 23.08.2016.
 */
public class AddProductGroupServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String PGshortNameField = request.getParameter("PGshortName");
        String PGdescriptionField = request.getParameter("PGdescription");
        ProductGroup productGroup = new ProductGroup(
                PGshortNameField,
                PGdescriptionField);
        // достаём введённый текст по атрибуту name тэга input.
        ProductGroupDaoImpl.getInstance().create(productGroup);
        /*После добавления возвращаемся обратно на данную страницу.*/
        response.sendRedirect("/productGroupsServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
