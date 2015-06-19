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
    private BibliotecaBufferedReader bufferedReader;
    private Menu menu;

    @Before
    public void setUp() {
        bufferedReader = mock(BibliotecaBufferedReader.class);
        biblioteca = mock(Biblioteca.class);
        menu = mock(Menu.class);
        bibliotecaApp = new BibliotecaApp(biblioteca, bufferedReader, menu);
    }

    @Test
    public void shouldDisplayWelcomeMessageOnRun(){
        when(menu.readInput()).thenReturn(3);
        bibliotecaApp.run();
        verify(menu).printWelcomeMessage();
    }

    @Test
    public void shouldGetUserInputAfterMenuDisplayed() {
        when(menu.readInput()).thenReturn(3);
        bibliotecaApp.run();
        verify(menu).readInput();
    }

    @Test
    public void shouldStopRunningWhenQuitIsSelectedFromMenu() {
        when(menu.readInput()).thenReturn(1).thenReturn(1).thenReturn(3);
        assertThat(bibliotecaApp.run(), is(true));
    }

    @Test
    public void shouldCallCheckOutBookOnBibliotecaWhenOptionTwoIsChosen(){
        when(menu.readInput()).thenReturn(2).thenReturn(3);

        bibliotecaApp.selectFromMenu();

        verify(biblioteca).checkoutBook();
    }

}
