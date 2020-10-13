package com.jisoh.keybinding;

import com.jisoh.keybinding.Result;
import java.util.List;

public interface ResultService {

    List<Result> findResult();

    void emptyResult();
    
    void saveResult(List<Result> results);
}