package com.ilyagubarev.quotepad.web.context.data;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ilyagubarev.quotepad.structures.Quote;
import com.ilyagubarev.quotepad.structures.User;
import com.ilyagubarev.quotepad.web.context.ConcurrentBean;
import com.ilyagubarev.quotepad.web.data.QuoteRepository;

@Repository
public class QuoteRepositoryBean extends ConcurrentBean
        implements QuoteRepository {

    private final Map<Integer, Quote> quotes = new HashMap<>();

    private int sequence = 1;

    @Override
    public Quote add(User user, Quote blank) {
        try {
            lockWhileWrite();
            blank.setId(sequence++);
            quotes.put(blank.getId(), blank);
            return blank;
        } finally {
            unlockAfterWrite();
        }
    }

    @Override
    public Map<Integer, Quote> filter(User user, Integer authorId, Integer workId) {
        try {
            lockWhileRead();
            Map<Integer, Quote> result = new HashMap<>();
            quotes.forEach((id, quote) -> {
                if (authorId != null && !authorId.equals(quote.getAuthorId())) {
                    return;
                }
                if (workId != null && !workId.equals(quote.getWorkId())) {
                    return;
                }
                result.put(id, quote);
            });
            return result;
        } finally {
            unlockAfterRead();
        }
    }

    @Override
    public Quote get(User user, int id) {
        try {
            lockWhileRead();
            return quotes.get(id);
        } finally {
            unlockAfterRead();
        }
    }

    @Override
    public void remove(User user, int id) {
        try {
            lockWhileWrite();
            quotes.remove(id);
        } finally {
            unlockAfterWrite();
        }
    }

    @Override
    public Quote set(User user, int id, Quote blank) {
        try {
            lockWhileWrite();
            Quote result = quotes.get(id);
            result.setAuthorId(blank.getAuthorId());
            result.setText(blank.getText());
            result.setWorkId(blank.getWorkId());
            return result;
        } finally {
            unlockAfterWrite();
        }
    }
}
