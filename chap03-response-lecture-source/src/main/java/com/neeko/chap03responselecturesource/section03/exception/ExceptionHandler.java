package com.neeko.chap03responselecturesource.section03.exception;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/* Custom Error Page 응답하는 서블릿 */
@WebServlet(value = "/showErrorPage")
public class ExceptionHandler extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Enumeration<String> attrs = req.getAttributeNames();
        while (attrs.hasMoreElements()) {
            String attr = attrs.nextElement();
            System.out.println(attr+" : "+req.getAttribute(attr));
        }


        int statutsCode =(int)req.getAttribute("jakarta.servlet.error.status_code");
        String message = (String)req.getAttribute("jakarta.servlet.error.message");
        String servletName = (String)req.getAttribute("jakarta.servlet.error.servlet_name");

        StringBuilder sb = new StringBuilder();
        sb.append("<html>")
                .append("<head>")
                .append("<title>응답페이지</title>")
                .append("</head>")
                .append("<body><h1>")
                .append(statutsCode)
                .append("</h1><h2>")
                .append(message)
                .append("</h2><h3>")
                .append(servletName)
                .append("</h3></body>")
                .append("</html>");

        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();
        printWriter.println(sb);
        printWriter.flush();
        printWriter.close();



    }
}
