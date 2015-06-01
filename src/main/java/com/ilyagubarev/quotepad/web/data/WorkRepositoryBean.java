package com.ilyagubarev.quotepad.web.data;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ilyagubarev.quotepad.structures.User;
import com.ilyagubarev.quotepad.structures.Work;

@Repository
public class WorkRepositoryBean extends ConcurrentBean
        implements WorkRepository {

    private final Map<Integer, Work> works = new HashMap<>();

    private int sequence = 1;

    @Override
    public Work add(User user, Work blank) {
        try {
            lockWhileWrite();
            blank.setId(sequence++);
            works.put(blank.getId(), blank);
            return blank;
        } finally {
            unlockAfterWrite();
        }
    }

    @Override
    public Map<Integer, Work> filter(User user, Integer authorId, String type) {
        try {
            lockWhileRead();
            Map<Integer, Work> result = new HashMap<>();
            works.forEach((id, work) -> {
                if (authorId != null && !authorId.equals(work.getAuthorId())) {
                    return;
                }
                if (type != null && !type.equals(work.getType())) {
                    return;
                }
                result.put(id, work);
            });
            return result;
        } finally {
            unlockAfterRead();
        }
    }

    @Override
    public Work get(User user, int id) {
        try {
            lockWhileRead();
            return works.get(id);
        } finally {
            unlockAfterRead();
        }
    }

    @Override
    public void remove(User user, int id) {
        try {
            lockWhileWrite();
            works.remove(id);
        } finally {
            unlockAfterWrite();
        }
    }

    @Override
    public Work set(User user, int id, Work blank) {
        try {
            lockWhileWrite();
            Work result = works.get(id);
            result.setAuthorId(blank.getAuthorId());
            result.setDescription(blank.getDescription());
            result.setTitle(blank.getTitle());
            result.setType(blank.getType());
            result.setYear(blank.getYear());
            return result;
        } finally {
            unlockAfterWrite();
        }
    }
}
