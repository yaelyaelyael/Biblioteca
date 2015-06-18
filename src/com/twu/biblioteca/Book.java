package com.twu.biblioteca;

import com.sun.deploy.util.StringUtils;

public class Book {
    private String bookName;
    private String author;
    private String year;

    public Book(String bookName, String author, String year) {
        this.bookName = bookName;
        this.author = author;
        this.year = year;
    }

    public String getBookDetails() {
        return String.format("%-25s %-25s %s",bookName,author,year);
    }
}
