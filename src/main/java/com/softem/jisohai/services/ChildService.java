package com.softem.jisohai.services;

import com.softem.jisohai.models.Children;
import java.util.List;

public interface ChildService {

    List<Children> findAll();

    void emptyAll();
    
    void saveAll(List<Children> books);
}