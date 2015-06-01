package com.ilyagubarev.quotepad.web;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class MainPageResolver implements Filter {

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String path = httpRequest.getContextPath();
        String uri = httpRequest.getRequestURI();
        String resource = uri.substring(path.length()).toLowerCase();
        if (resource.startsWith("/resources")) {
            chain.doFilter(request, response);
        } else {
            httpRequest.setAttribute("system", system(httpRequest));
            request.getRequestDispatcher("/resources/templates/main").forward(request, response);
        }
    }

    @Override
    public void destroy() {

    }

    private String path(HttpServletRequest request) {
        return new StringBuilder()
                .append(request.getScheme())
                .append("://")
                .append(request.getServerName())
                .append(":")
                .append(request.getServerPort())
                .append(request.getContextPath())
                .append("/home")
                .toString();
    }

    private Object system(HttpServletRequest request) {
        Properties result = new Properties();
        result.put("path", path(request));
        return result;
    }
}
