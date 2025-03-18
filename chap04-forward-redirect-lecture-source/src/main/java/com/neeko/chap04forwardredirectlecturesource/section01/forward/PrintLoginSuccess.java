package com.neeko.chap04forwardredirectlecturesource.section01.forward;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/print")
public class PrintLoginSuccess extends HttpServlet {

    /* forward된 servlet에서도 요청 방식이 그대로 유지된다. post -> post
     * 또한 전달된 req, resp의 모든 전보를 이용해 새로운 req, resp를 깊은 복사를 통해 만들어
     * 전달하므로 데이터가 그래도 유지된다. */

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = (String)req.getAttribute("userName");;
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<h1>"+userName+"님 환영합니다. </h1>");
        out.flush();
        out.close();


    }




}
