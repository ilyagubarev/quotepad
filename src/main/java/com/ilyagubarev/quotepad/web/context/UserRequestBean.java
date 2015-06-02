package com.ilyagubarev.quotepad.web.context;

import com.ilyagubarev.quotepad.structures.User;

public abstract class UserRequestBean extends RequestBean {

    protected User user() {
        return new User();
    }
}
