package com.ilyagubarev.quotepad.web.context.presentation.models;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import static org.springframework.web.bind.annotation.RequestMethod.*;

import com.ilyagubarev.quotepad.structures.Work;
import com.ilyagubarev.quotepad.web.logic.WorkService;

@Controller
@RequestMapping("/works")
public class WorkControllerBean extends ModelPresentationBean {

    @Autowired
    private WorkService works;

    @RequestMapping(method = POST, consumes = JSON, produces = JSON)
    public Work add(@RequestBody Work blank) {
        return works.add(user(), blank);
    }

    @RequestMapping(method = GET, produces = JSON)
    public Collection<Work> filter(@RequestParam(value = "authorId", required = false) Integer authorId, @RequestParam(value = "type", required = false) String type) {
        return works.filter(user(), authorId, type).values();
    }

    @RequestMapping(value = "/{id}", method = GET, produces = JSON)
    public Work get(@PathVariable("id") int id) {
        return works.get(user(), id);
    }

    @RequestMapping(value = "/{id}", method = DELETE)
    public void remove(@PathVariable("id") int id) {
        works.remove(user(), id);
    }

    @RequestMapping(value = "/{id}", method = PUT, produces = JSON)
    public Work set(@PathVariable("id") int id, @RequestBody Work blank) {
        return works.set(user(), id, blank);
    }
}
