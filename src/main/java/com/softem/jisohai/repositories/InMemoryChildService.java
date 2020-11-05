package com.softem.jisohai.repositories;

import org.springframework.stereotype.Service;

import com.softem.jisohai.models.Children;
import com.softem.jisohai.services.ChildService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

// saving your input data into list
@Service
public class InMemoryChildService implements ChildService {

    static Map<Long, Children> childrenDB = new HashMap<>();

    @Override
    public List<Children> findAll() {
        return new ArrayList<>(childrenDB.values());
    }
    
    @Override
    public void emptyAll() {
    	childrenDB = new HashMap<>();
    }

    @Override
    public void saveAll(List<Children> children) {
        long nextId = getNextId();
        for (Children child : children) {
            if (child.getId() == 0) {
                child.setId(nextId++);
            }
        }

        Map<Long, Children> bookMap = children.stream()
            .collect(Collectors.toMap(Children::getId, Function.identity()));

        childrenDB.putAll(bookMap);
    }

    private Long getNextId() {
        return childrenDB.keySet()
            .stream()
            .mapToLong(value -> value)
            .max()
            .orElse(0) + 1;
    }

}