package com.ilyagubarev.quotepad.web.data;

import java.util.Map;

import com.ilyagubarev.quotepad.structures.Author;
import com.ilyagubarev.quotepad.structures.User;

public interface AuthorRepository {

    Author add(User user, Author blank);

    Map<Integer, Author> filter(User user, String country);

    Author get(User user, int id);

    void remove(User user, int id);

    Author set(User user, int id, Author blank);
}
