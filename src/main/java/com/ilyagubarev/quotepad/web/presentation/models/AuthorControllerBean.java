package com.ilyagubarev.quotepad.web.presentation.models;

import java.util.Collection;
import java.util.LinkedList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
@RequestMapping("/authors")
public class AuthorControllerBean extends AbstractControllerBean {

    @RequestMapping(method = GET, produces = JSON)
    public Collection<Object> filter() {
        return new LinkedList<>();
    }
}
