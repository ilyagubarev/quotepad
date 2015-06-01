package com.ilyagubarev.quotepad.web.data;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ilyagubarev.quotepad.structures.Author;
import com.ilyagubarev.quotepad.structures.User;

@Repository
public class AuthorRepositoryBean extends ConcurrentBean
        implements AuthorRepository {

    private final Map<Integer, Author> authors = new HashMap<>();

    private int sequence = 1;

    @Override
    public Author add(User user, Author blank) {
        try {
            lockWhileWrite();
            blank.setId(sequence++);
            authors.put(blank.getId(), blank);
            return blank;
        } finally {
            unlockAfterWrite();
        }
    }

    @Override
    public Map<Integer, Author> filter(User user, String country) {
        try {
            lockWhileRead();
            Map<Integer, Author> result = new HashMap<>();
            authors.forEach((id, author) -> {
                if (country != null && !country.equals(author.getCountry())) {
                    return;
                }
                result.put(id, author);
            });
            return result;
        } finally {
            unlockAfterRead();
        }
    }

    @Override
    public Author get(User user, int id) {
        try {
            lockWhileRead();
            return authors.get(id);
        } finally {
            unlockAfterRead();
        }
    }

    @Override
    public void remove(User user, int id) {
        try {
            lockWhileWrite();
            authors.remove(id);
        } finally {
            unlockAfterWrite();
        }
    }

    @Override
    public Author set(User user, int id, Author blank) {
        try {
            lockWhileWrite();
            Author result = authors.get(id);
            result.setBirth(blank.getBirth());
            result.setCountry(blank.getCountry());
            result.setDeath(blank.getDeath());
            result.setDescription(blank.getDescription());
            result.setName(blank.getName());
            return result;
        } finally {
            unlockAfterWrite();
        }
    }
}
