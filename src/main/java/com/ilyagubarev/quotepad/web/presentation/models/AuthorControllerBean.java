package com.ilyagubarev.quotepad.web.presentation.models;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.*;

import com.ilyagubarev.quotepad.structures.Author;
import com.ilyagubarev.quotepad.web.logic.AuthorService;

@Controller
@RequestMapping("/authors")
public class AuthorControllerBean extends AbstractControllerBean {

    @Autowired
    private AuthorService authors;

    @RequestMapping(method = POST, consumes = JSON, produces = JSON)
    public Author add(@RequestBody Author author) {
        return authors.add(null, author);
    }

    @RequestMapping(method = GET, produces = JSON)
    public Collection<Author> filter() {
        return authors.filter(null, null).values();
    }
}
