package com.ilyagubarev.quotepad.web.logic;

import java.util.Map;

import com.ilyagubarev.quotepad.structures.User;
import com.ilyagubarev.quotepad.structures.Work;

public interface WorkService {

    Work add(User user, Work blank);

    Map<Integer, Work> filter(User user, Integer authorId, String type);

    Work get(User user, int id);

    void remove(User user, int id);

    Work set(User user, int id, Work blank);
}
