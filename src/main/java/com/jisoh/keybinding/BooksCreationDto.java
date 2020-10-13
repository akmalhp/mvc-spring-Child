package com.jisoh.keybinding;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.jisoh.keybinding.PrimaryKey;

public class BooksCreationDto {

	// create List "books" for PrimaryKey
    private List<PrimaryKey> books;

    public BooksCreationDto() {
        this.books = new ArrayList<>();
    }

    public BooksCreationDto(List<PrimaryKey> books) {
        this.books = books;
    }
    
    // getters and setters
    public List<PrimaryKey> getBooks() {
        return books;
    }

    public void setBooks(List<PrimaryKey> books) {
        this.books = books;
    }
    
    
    // method to add variable
    public void addBook(PrimaryKey primarykey) {
        this.books.add(primarykey);
    }
}