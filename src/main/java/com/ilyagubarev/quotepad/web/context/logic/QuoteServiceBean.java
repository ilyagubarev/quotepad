package com.ilyagubarev.quotepad.web.context.logic;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ilyagubarev.quotepad.structures.Quote;
import com.ilyagubarev.quotepad.structures.User;
import com.ilyagubarev.quotepad.web.context.Bean;
import com.ilyagubarev.quotepad.web.data.QuoteRepository;
import com.ilyagubarev.quotepad.web.logic.QuoteService;

@Service
public class QuoteServiceBean extends Bean implements QuoteService {

    @Autowired
    private QuoteRepository quotes;

    @Override
    public Quote add(User user, Quote blank) {
        return quotes.add(user, blank);
    }

    @Override
    public Map<Integer, Quote> filter(User user, Integer authorId, Integer workId) {
        return quotes.filter(user, authorId, workId);
    }

    @Override
    public Quote get(User user, int id) {
        return quotes.get(user, id);
    }

    @Override
    public void remove(User user, int blank) {
        quotes.remove(user, blank);
    }

    @Override
    public Quote set(User user, int id, Quote blank) {
        return quotes.set(user, id, blank);
    }
}
