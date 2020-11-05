package com.softem.jisohai.repositories;

import org.springframework.stereotype.Service;

import com.softem.jisohai.models.Result;
import com.softem.jisohai.services.ResultService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

// saving your input data into list
@Service
public class InMemoryResultService implements ResultService {

    static Map<Long, Result> resultsDB = new HashMap<>();

    @Override
    public List<Result> findResult() {
        return new ArrayList<>(resultsDB.values());
    }
    
    @Override
    public void emptyResult() {
    	resultsDB = new HashMap<>();
    }

    @Override
    public void saveResult(List<Result> results) {
        long nextId = getNextId();
        for (Result result : results) {
            if (result.getId() == 0) {
                result.setId(nextId++);
            }
        }

        Map<Long, Result> resultMap = results.stream()
            .collect(Collectors.toMap(Result::getId, Function.identity()));

        resultsDB.putAll(resultMap);
    }

    private Long getNextId() {
        return resultsDB.keySet()
            .stream()
            .mapToLong(value -> value)
            .max()
            .orElse(0) + 1;
    }
}