package com.ilyagubarev.quotepad.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class ScriptResolver implements Filter {

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String path = httpRequest.getContextPath();
        String uri = httpRequest.getRequestURI();
        String resource = uri.substring(path.length());
        String template = String.format("/WEB-INF%s.js", resource);
        request.getRequestDispatcher(template).forward(request, response);
    }

    @Override
    public void destroy() {

    }
}
