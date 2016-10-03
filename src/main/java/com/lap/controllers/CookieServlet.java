package com.lap.controllers;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by lapte on 14.09.2016.
 */
public class CookieServlet extends HttpServlet {
    //Сервлет считает, сколько раз мы зашли на данную страницу.
    private static final String COOKIE_NAME = "counter";
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Cookie [] cookies = request.getCookies();
        Cookie fromClient = null;
        for (Cookie cookie : cookies) {
            if(COOKIE_NAME.equals(cookie.getName())){
                fromClient = cookie;
                break;
            }
        }
        if(fromClient == null){
            response.addCookie(new Cookie(COOKIE_NAME,"1"));
            response.getWriter().write("You visit this page " + 1 + " time.");
        }else {
            int visitCount = Integer.valueOf(fromClient.getValue());
            response.addCookie(new Cookie(COOKIE_NAME, "" + (++visitCount)));

            //создадим ещё одно cookie, помимо "counter", назовём его "name".
            response.addCookie(new Cookie("name", "Hello"));

            response.getWriter().write("You visit this page " + visitCount + " times.");
        }
    }
}
