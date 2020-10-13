package com.jisoh.keybinding;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.jisoh.keybinding.Result;

public class ResultsCreationDto {

	// create List "books" for PrimaryKey
    private List<Result> results;

    public ResultsCreationDto() {
        this.results = new ArrayList<>();
    }

    public ResultsCreationDto(List<Result> results) {
        this.results = results;
    }
    
    // getters and setters
    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }
    
    
//    // method to add variable
//    public void addBook(PrimaryKey primarykey) {
//        this.books.add(primarykey);
//    }
}