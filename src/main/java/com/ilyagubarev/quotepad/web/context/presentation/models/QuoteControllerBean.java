package com.ilyagubarev.quotepad.web.context.presentation.models;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import static org.springframework.web.bind.annotation.RequestMethod.*;

import com.ilyagubarev.quotepad.structures.Quote;
import com.ilyagubarev.quotepad.web.logic.QuoteService;

@Controller
@RequestMapping("/quotes")
public class QuoteControllerBean extends ModelPresentationBean {

    @Autowired
    private QuoteService quotes;

    @RequestMapping(method = POST, consumes = JSON, produces = JSON)
    public Quote add(@RequestBody Quote blank) {
        return quotes.add(user(), blank);
    }

    @RequestMapping(method = GET, produces = JSON)
    public Collection<Quote> filter(@RequestParam(value = "authorId", required = false) Integer authorId, @RequestParam(value = "workId", required = false) Integer workId) {
        return quotes.filter(user(), authorId, workId).values();
    }

    @RequestMapping(value = "/{id}", method = GET, produces = JSON)
    public Quote get(@PathVariable("id") int id) {
        return quotes.get(user(), id);
    }

    @RequestMapping(value = "/{id}", method = DELETE)
    public void remove(@PathVariable("id") int id) {
        quotes.remove(user(), id);
    }

    @RequestMapping(value = "/{id}", method = PUT, produces = JSON)
    public Quote set(@PathVariable("id") int id, @RequestBody Quote blank) {
        return quotes.set(user(), id, blank);
    }
}
