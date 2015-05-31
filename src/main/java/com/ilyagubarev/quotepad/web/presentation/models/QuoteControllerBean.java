package com.ilyagubarev.quotepad.web.presentation.models;

import java.util.Collection;
import java.util.LinkedList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import com.ilyagubarev.quotepad.structures.Quote;

@Controller
@RequestMapping("/quotes")
public class QuoteControllerBean extends AbstractControllerBean {

    @RequestMapping(method = GET, produces = JSON)
    public Collection<Quote> filter() {
        return new LinkedList<>();
    }
}
