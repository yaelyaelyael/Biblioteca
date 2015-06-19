package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.List;

public class Biblioteca {
    private List<Book> books;
    private PrintStream printStream;

    Biblioteca(List<Book> books, PrintStream printStream){
        this.books = books;
        this.printStream = printStream;
    }

    public void printListOfBooks() {
        String listofBooks = "";
        for (Book book : books) {
            listofBooks += book.getBookDetails() + "\n";
        }
        printStream.print(listofBooks);
    }

    public void checkoutBook() {
        printStream.print("Choose a book to checkout");
    }
}