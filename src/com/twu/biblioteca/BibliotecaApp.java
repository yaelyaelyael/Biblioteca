package com.twu.biblioteca;

import java.io.InputStreamReader;
import java.util.ArrayList;

public class BibliotecaApp {

    private Biblioteca biblioteca;
    private Menu menu;
    private BibliotecaBufferedReader bufferedReader;


    BibliotecaApp(Biblioteca biblioteca, BibliotecaBufferedReader bufferedReader, Menu menu){
        this.biblioteca = biblioteca;
        this.bufferedReader = bufferedReader;
        this.menu = menu;
    }

    public boolean run(){
        boolean runComplete = false;

        menu.printWelcomeMessage();

        menu.displayMenu();
        do {
            runComplete = selectFromMenu();
        }while(!runComplete);

        return runComplete;
    }

    public boolean selectFromMenu() {
        boolean runComplete = false;
        int input =  menu.readInput();
        if(input == 1){
            biblioteca.printListOfBooks();
        }
        else if(input == 2){
            runComplete = true;
        }
        return runComplete;
    }

    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Go Dog Go", "Dr Suess", "1990"));
        books.add(new Book("Green Eggs and Ham", "Dr Suess", "1991"));
        Biblioteca biblioteca = new Biblioteca(books, System.out);
        InputStreamReader in = new InputStreamReader(System.in);
        BibliotecaBufferedReader bufferedReader = new BibliotecaBufferedReader(in);
        Menu menu = new Menu(System.out, bufferedReader);
        new BibliotecaApp(biblioteca, bufferedReader, menu).run();
    }
}
