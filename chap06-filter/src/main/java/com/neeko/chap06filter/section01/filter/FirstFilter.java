package com.neeko.chap06filter.section01.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;


@WebFilter("/first/*")
public class FirstFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter init 메소드 호출");
    }



    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        /* 서블릿 호출 전 처리 코드 */
        System.out.println("Filter doFilter 메소드 호출");

        /* 현재 필터에서 다음 필터 또는 서블릿을 호출하는 코드*/
        filterChain.doFilter(servletRequest, servletResponse);

        /* 서블릿 호출 후 처리 코드*/
        System.out.println("서블릿 요청 수행 완료");

    }
    @Override
    public void destroy() {


        System.out.println("Filter destroy 메소드 호출");

    }
}
