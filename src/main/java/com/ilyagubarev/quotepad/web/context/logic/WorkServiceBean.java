package com.ilyagubarev.quotepad.web.context.logic;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ilyagubarev.quotepad.structures.User;
import com.ilyagubarev.quotepad.structures.Work;
import com.ilyagubarev.quotepad.web.context.Bean;
import com.ilyagubarev.quotepad.web.data.WorkRepository;
import com.ilyagubarev.quotepad.web.logic.WorkService;

@Service
public class WorkServiceBean extends Bean implements WorkService {

    @Autowired
    private WorkRepository works;

    @Override
    public Work add(User user, Work blank) {
        return works.add(user, blank);
    }

    @Override
    public Map<Integer, Work> filter(User user, Integer authorId, String type) {
        return works.filter(user, authorId, type);
    }

    @Override
    public Work get(User user, int id) {
        return works.get(user, id);
    }

    @Override
    public void remove(User user, int id) {
        works.remove(user, id);
    }

    @Override
    public Work set(User user, int id, Work blank) {
        return works.set(user, id, blank);
    }
}
