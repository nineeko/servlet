package com.neeko.chap04forwardredirectlecturesource.section02.redirect;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/redirect")
public class Redirect extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("이 서블릿으로 redirect 완료!");

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<h1>이 서블릿으로 redirect 완료!");
        out.println("<br>");
        out.flush();
        out.close();
    }
}
