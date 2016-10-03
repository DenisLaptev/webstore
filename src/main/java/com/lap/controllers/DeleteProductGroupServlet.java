package com.lap.controllers;

import com.lap.dao.impl.ProductGroupDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by lapte on 23.08.2016.
 */
@WebServlet(name = "DeleteProductGroupServlet", urlPatterns = "/deleteProductGroup")
public class DeleteProductGroupServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        long PGid = Long.parseLong(request.getParameter("id"));
        ProductGroupDaoImpl.getInstance().delete(PGid);
        /*После удаления возвращаемся обратно на данную страницу.*/
        response.sendRedirect("/productGroupsServlet");
    }
}
