package com.neeko.section01.cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/cookie")
public class CookieHandler extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        /* 1. 쿠키 생성 */
        Cookie firstNameCookie = new Cookie("firstName", firstName);
        Cookie lastNameCookie = new Cookie("lastName", lastName);

        /* 2. 쿠키 만료 시간 설정 */
        firstNameCookie.setMaxAge(60*60*24);
        lastNameCookie.setMaxAge(60*60*24);

        /* 3. 응답 헤더에 쿠키를 담음 */
        resp.addCookie(firstNameCookie);
        resp.addCookie(lastNameCookie);

        resp.sendRedirect("cookie-redirect");





    }

}
