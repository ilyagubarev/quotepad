package com.ilyagubarev.quotepad.web.presentation.models;

import java.util.Collection;
import java.util.LinkedList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import com.ilyagubarev.quotepad.structures.Work;

@Controller
@RequestMapping("/works")
public class WorkControllerBean extends AbstractControllerBean {

    @RequestMapping(method = GET, produces = JSON)
    public Collection<Work> filter() {
        return new LinkedList<>();
    }
}
