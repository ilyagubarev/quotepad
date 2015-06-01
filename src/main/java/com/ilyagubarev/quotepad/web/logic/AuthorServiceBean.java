package com.ilyagubarev.quotepad.web.logic;

import java.util.Collection;
import java.util.LinkedList;

import org.springframework.stereotype.Service;

import com.ilyagubarev.quotepad.structures.Author;

@Service
public class AuthorServiceBean implements AuthorService {

    private final Collection<Author> authors;

    public AuthorServiceBean() {
        this.authors = new LinkedList<>();
        Author shakespeare = new Author();
        shakespeare.setId(1);
        shakespeare.setName("Shakespeare, William");
        shakespeare.setDescription("A short description for Shakespeare");
        shakespeare.setCountry("England");
        shakespeare.setBirth(0L);
        shakespeare.setDeath(0L);
        this.authors.add(shakespeare);
        Author huxley = new Author();
        huxley.setId(2);
        huxley.setName("Huxley, Aldous");
        huxley.setDescription("A short description for Huxley");
        huxley.setCountry("England");
        huxley.setBirth(0L);
        huxley.setDeath(0L);
        this.authors.add(huxley);
    }

    @Override
    public Author add(Author author) {
        authors.add(author);
        return author;
    }

    @Override
    public Collection<Author> filter() {
        return authors;
    }
}
