package com.softem.jisohai.services;

import com.softem.jisohai.models.Result;
import java.util.List;

public interface ResultService {

    List<Result> findResult();

    void emptyResult();
    
    void saveResult(List<Result> results);
}