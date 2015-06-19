package com.twu.biblioteca;

public class Book {
    private boolean checkedOut;
    private String bookName;
    private String author;
    private String year;

    public Book(String bookName, String author, String year) {
        this.bookName = bookName;
        this.author = author;
        this.year = year;
        this.checkedOut = false;
    }

    public String getBookDetails() {
        return String.format("%-25s %-25s %s",bookName,author,year);
    }

    public void markAsCheckedOut() {
        this.checkedOut = true;
    }

    public boolean isChecked() {
        return this.checkedOut;
    }
}
