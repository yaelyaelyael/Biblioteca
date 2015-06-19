package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cbiggs on 6/17/15.
 */
public class Menu {

    private BibliotecaBufferedReader bufferedReader;
    private PrintStream printStream;
    private List<Integer> validOptionsList = new ArrayList<Integer>();

    public Menu(PrintStream printStream, BibliotecaBufferedReader bufferedReader) {
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
        validOptionsList.add(1);
        validOptionsList.add(2);
        validOptionsList.add(3);
    }

    public void displayMenu() {
        printStream.println("1) List Books");
        printStream.println("2) Checkout book");
        printStream.println("3) Quit");
    }

    public int readInput(){
        printStream.print("Enter an option: ");
        int input;

        try {
            input = Integer.parseInt(bufferedReader.readLine());

            if(!validOptionsList.contains(input)){
                input = -1;
                printStream.println("Select a valid option!");
            }
        } catch (NumberFormatException numFormatException) {
            input = -1;
            printStream.println("Select a valid option!");
        }

        return input;
    }

    public void printWelcomeMessage() {
        printStream.println("Welcome to the Biblioteca!");
    }

}
