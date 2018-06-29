package com.cryptoeagle.controller;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class WelcomeController extends HttpServlet {


    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = (String) req.getParameter("name");
        String email = (String) req.getParameter("email");
        String password = (String) req.getParameter("password");

        HttpSession session = req.getSession();


        req.setAttribute("visible", true);
//        req.setAttribute("visible", false);

        req.getRequestDispatcher("/views/welcome.jsp").forward(req, resp);
    }
}
