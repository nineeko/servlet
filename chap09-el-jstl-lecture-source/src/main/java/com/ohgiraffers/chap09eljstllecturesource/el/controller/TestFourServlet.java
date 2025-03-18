package com.ohgiraffers.chap09eljstllecturesource.el.controller;

import com.ohgiraffers.chap09eljstllecturesource.el.model.dto.MemberDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/test4")
public class TestFourServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MemberDTO sessionMember = new MemberDTO("홍길동", 19, "010-1234-5678", "gildong@ohgiraffers.com");
        MemberDTO requestMember = new MemberDTO("유관순", 16, "010-9876-5432", "yoo@ohgiraffers.com");

        HttpSession session = req.getSession();
        session.setAttribute("member", sessionMember);
        req.setAttribute("member", requestMember);

        RequestDispatcher rd = req.getRequestDispatcher("views/el/testEl4.jsp");
        rd.forward(req, resp);

    }
}
