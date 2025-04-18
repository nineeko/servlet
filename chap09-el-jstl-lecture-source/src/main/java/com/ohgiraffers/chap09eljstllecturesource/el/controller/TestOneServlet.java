package com.ohgiraffers.chap09eljstllecturesource.el.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/test1")
public class TestOneServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("name", "홍길동");
        req.setAttribute("age", 19);
        req.setAttribute("phone", "010-1234-5678");

        List<String> items = new ArrayList<>();
        items.add("apple");
        items.add("banana");
        items.add("melon");

        req.setAttribute("items", items);

        RequestDispatcher rd = req.getRequestDispatcher("views/el/testEl1.jsp");
        rd.forward(req, resp);
    }
}
