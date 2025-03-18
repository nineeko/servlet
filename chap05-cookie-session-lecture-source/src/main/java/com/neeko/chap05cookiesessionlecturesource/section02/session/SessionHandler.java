package com.neeko.chap05cookiesessionlecturesource.section02.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(value = "/session")
public class SessionHandler extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /* 서버 쪽에서 안전하게 관리할 수 있는 세션이라는 인스턴스를 통해 상태 유지 메커니즘이 제공된다. */
        HttpSession session = req.getSession();

        /* 세션 브라우저 당 한 개의 고유 아이디를 가지고 하나의 인스턴스를 이용한다.
        * 반복 요청 시 동일 session id를 반환한다.
        * 단, 브라우저가 종료되면 해당 세션이 종료되므로 그 이후의 요청은 다른 session id를 반환한다.
        * session id는 cookie에 저장되어 있다. */
        System.out.println(session.getId());

        System.out.println(session.getMaxInactiveInterval());   // 세션의 기본 유지 시간은 30분
        session.setMaxInactiveInterval(60 * 10);                // 필요에 따라 늘리거나 줄임 (10분)
        System.out.println(session.getMaxInactiveInterval());

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");

        session.setAttribute("firstName", firstName);
        session.setAttribute("lastName", lastName);

        resp.sendRedirect("session-redirect");
    }

}
