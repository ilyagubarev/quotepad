package com.ilyagubarev.quotepad.web.context.presentation.models;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import static org.springframework.web.bind.annotation.RequestMethod.*;

import com.ilyagubarev.quotepad.structures.Author;
import com.ilyagubarev.quotepad.web.logic.AuthorService;

@Controller
@RequestMapping("/authors")
public class AuthorControllerBean extends ModelPresentationBean {

    @Autowired
    private AuthorService authors;

    @RequestMapping(method = POST, consumes = JSON, produces = JSON)
    public Author add(@RequestBody Author blank) {
        return authors.add(user(), blank);
    }

    @RequestMapping(method = GET, produces = JSON)
    public Collection<Author> filter(@RequestParam(value = "country", required = false) String country) {
        return authors.filter(user(), country).values();
    }

    @RequestMapping(value = "/{id}", method = GET, produces = JSON)
    public Author get(@PathVariable("id") int id) {
        return authors.get(user(), id);
    }

    @RequestMapping(value = "/{id}", method = DELETE)
    public void remove(@PathVariable("id") int id) {
        authors.remove(user(), id);
    }

    @RequestMapping(value = "/{id}", method = PUT, produces = JSON)
    public Author set(@PathVariable("id") int id, @RequestBody Author blank) {
        return authors.set(user(), id, blank);
    }
}
