package com.ilyagubarev.quotepad.web.logic;

import java.util.Collection;

import com.ilyagubarev.quotepad.structures.Author;

public interface AuthorService {

    Collection<Author> filter();
}
