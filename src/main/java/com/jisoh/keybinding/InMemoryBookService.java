package com.jisoh.keybinding;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

// saving your input data into list
@Service
public class InMemoryBookService implements BookService {

    static Map<Long, PrimaryKey> booksDB = new HashMap<>();

    @Override
    public List<PrimaryKey> findAll() {
        return new ArrayList<>(booksDB.values());
    }
    
    @Override
    public void emptyAll() {
    	booksDB = new HashMap<>();
    }

    @Override
    public void saveAll(List<PrimaryKey> books) {
        long nextId = getNextId();
        for (PrimaryKey primarykey : books) {
            if (primarykey.getId() == 0) {
                primarykey.setId(nextId++);
            }
        }

        Map<Long, PrimaryKey> bookMap = books.stream()
            .collect(Collectors.toMap(PrimaryKey::getId, Function.identity()));

        booksDB.putAll(bookMap);
    }

    private Long getNextId() {
        return booksDB.keySet()
            .stream()
            .mapToLong(value -> value)
            .max()
            .orElse(0) + 1;
    }
}