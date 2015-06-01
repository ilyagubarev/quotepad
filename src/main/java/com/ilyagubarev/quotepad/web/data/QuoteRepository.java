package com.ilyagubarev.quotepad.web.data;

import java.util.Map;

import com.ilyagubarev.quotepad.structures.Quote;
import com.ilyagubarev.quotepad.structures.User;

public interface QuoteRepository {

    Quote add(User user, Quote blank);

    Map<Integer, Quote> filter(User user, Integer authorId, Integer workId);

    Quote get(User user, int id);

    void remove(User user, int blank);

    Quote set(User user, int id, Quote blank);
}
