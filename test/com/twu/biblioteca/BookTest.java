package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by dlafeir on 6/17/15.
 */
public class BookTest {

    private Book book;

    @Before
    public void setUp() {
        book = new Book("Go Dog Go", "Dr. Suess", "1990");
    }


    @Test
    public void shouldFormatBookInfomationWhenGettingDetails() {
        String booksToPrint = book.getBookDetails();

        assertThat(booksToPrint, is("Go Dog Go                 Dr. Suess                 1990"));
    }

    @Test
    public void shouldSetBookToCheckedOutWhenUserChecksOutBook() {
        book.markAsCheckedOut();

        assertThat(book.isChecked(), is(true));
    }

    @Test
    public void shouldNotBeCheckedWhenUserDidNotCheckOutBook() {
        assertThat(book.isChecked(), is(false));
    }
}