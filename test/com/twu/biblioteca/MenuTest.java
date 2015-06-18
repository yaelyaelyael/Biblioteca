package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Matchers.anySet;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by cbiggs on 6/17/15.
 */
public class MenuTest {

    private PrintStream printStream;
    private BufferedReader bufferedReader;
    private Menu menu;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        menu = new Menu(printStream, bufferedReader);
    }
    @Test
    public void shouldDisplayMenu(){
        menu.displayMenu();
        verify(printStream).println(anyString());
    }

    @Test
    public void shouldGetUserInput() {
        try {
            when(bufferedReader.readLine()).thenReturn("1");
            menu.readInput();
            verify(bufferedReader).readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldNotifyUserWhenUserChoosesMenuOptionThatDoesNotExist() {
        try {
            when(bufferedReader.readLine()).thenReturn("0");
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertThat(menu.readInput(), is(-1));
    }

    @Test
    public void shouldNotifyUserWhenUserChoosesInvalidMenuOption() {
        try {
            when(bufferedReader.readLine()).thenReturn("!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertThat(menu.readInput(), is(-1));
    }
}
