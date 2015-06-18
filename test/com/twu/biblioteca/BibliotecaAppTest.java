package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.*;

public class BibliotecaAppTest {

    private Biblioteca biblioteca;
    private BibliotecaApp bibliotecaApp;
    private BufferedReader bufferedReader;
    private Menu menu;

    @Before
    public void setUp() {
        bufferedReader = mock(BufferedReader.class);
        biblioteca = mock(Biblioteca.class);
        menu = mock(Menu.class);
        bibliotecaApp = new BibliotecaApp(biblioteca, bufferedReader, menu);
    }

    @Test
    public void shouldDisplayWelcomeMessageOnRun(){
        bibliotecaApp.run();
        verify(menu).printWelcomeMessage();
    }

    @Test
    public void shouldGetUserInputAfterMenuDisplayed() {
        bibliotecaApp.run();
        verify(menu).readInput();
    }

    @Test
    public void shouldStopRunningWhenQuitIsSelectedFromMenu() {
        when(menu.readInput()).thenReturn(1).thenReturn(1).thenReturn(2);
        assertThat(bibliotecaApp.run(), is(true));
    }
}
