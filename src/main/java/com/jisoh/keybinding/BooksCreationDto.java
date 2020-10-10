package com.jisoh.keybinding;

import java.util.ArrayList;
import java.util.List;

import com.jisoh.keybinding.PrimaryKey;

public class BooksCreationDto {

    private List<PrimaryKey> books;

    public BooksCreationDto() {
        this.books = new ArrayList<>();
    }

    public BooksCreationDto(List<PrimaryKey> books) {
        this.books = books;
    }

    public List<PrimaryKey> getBooks() {
        return books;
    }

    public void setBooks(List<PrimaryKey> books) {
        this.books = books;
    }

    public void addBook(PrimaryKey primarykey) {
        this.books.add(primarykey);
    }
}