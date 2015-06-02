package com.ilyagubarev.quotepad.web.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Scope("request")
public abstract class RequestBean extends Bean {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private HttpServletResponse response;

    protected HttpServletRequest request() {
        return request;
    }

    protected HttpServletResponse response() {
        return response;
    }
}
