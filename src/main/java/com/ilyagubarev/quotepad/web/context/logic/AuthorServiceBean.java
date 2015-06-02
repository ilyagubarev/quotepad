package com.ilyagubarev.quotepad.web.context.logic;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ilyagubarev.quotepad.structures.Author;
import com.ilyagubarev.quotepad.structures.User;
import com.ilyagubarev.quotepad.web.context.Bean;
import com.ilyagubarev.quotepad.web.data.AuthorRepository;
import com.ilyagubarev.quotepad.web.logic.AuthorService;

@Service
public class AuthorServiceBean extends Bean implements AuthorService {

    @Autowired
    private AuthorRepository authors;

    @Override
    public Author add(User user, Author blank) {
        return authors.add(user, blank);
    }

    @Override
    public Map<Integer, Author> filter(User user, String country) {
        return authors.filter(user, country);
    }

    @Override
    public Author get(User user, int id) {
        return authors.get(user, id);
    }

    @Override
    public void remove(User user, int id) {
        authors.remove(user, id);
    }

    @Override
    public Author set(User user, int id, Author blank) {
        return authors.set(user, id, blank);
    }
}
