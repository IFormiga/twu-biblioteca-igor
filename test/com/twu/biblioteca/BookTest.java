package com.twu.biblioteca;

import com.twu.biblioteca.models.Book;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {
    Book book;

    @Test
    public void shouldGetTheBookInfoInTheRightFormat(){
        book = new Book("Clean Code", "Robert Cecil Martin", 2008, 1);
        String bookInfo = book.getBookInfo();
        String expectedOutput = "Id: 1 | Name: Clean Code | Author: Robert Cecil Martin | Release Year: 2008";

        assertEquals(bookInfo, expectedOutput);
    }

    @Test
    public void shouldHaveAuthorInBookInfoIfIsNotNull(){
        book = new Book("Clean Code", "Robert Cecil Martin", 2008, 1);
        boolean bookInfoContainsAuthor = book.getBookInfo().contains("Author");

        assertTrue(bookInfoContainsAuthor);
    }

    @Test
    public void shouldNotHaveAuthorInBookInfoIfIsNull(){
        book = new Book("Clean Code", null, 2008, 1);
        boolean bookInfoDoNotContainsAuthor = !(book.getBookInfo().contains("Author"));

        assertTrue(bookInfoDoNotContainsAuthor);
    }

    @Test
    public void shouldHaveReleaseYearInBookInfoIfIsNot0(){
        book = new Book("Clean Code", "Robert Cecil Martin", 2008, 1);
        boolean bookInfoContainsReleaseYear = book.getBookInfo().contains("Release Year");

        assertTrue(bookInfoContainsReleaseYear);
    }

    @Test
    public void shouldNotHaveReleaseYearInBookInfoIfIs0(){
        book = new Book("Clean Code", "Robert Cecil Martin", 0, 1);
        boolean bookInfoDoNotContainsReleaseYear = !(book.getBookInfo().contains("Release Year"));

        assertTrue(bookInfoDoNotContainsReleaseYear);
    }

    @Test
    public void shouldHaveNameInBookInfoIfIsNotNull(){
        book = new Book("Clean Code", "Robert Cecil Martin", 2008, 1);
        boolean bookInfoContainsName = book.getBookInfo().contains("Name");

        assertTrue(bookInfoContainsName);
    }

    @Test
    public void shouldNotHaveNameInBookInfoIfIsNull(){
        book = new Book(null, "Robert Cecil Martin", 2008, 1);
        boolean bookInfoDoNotContainsName = !(book.getBookInfo().contains("Name"));

        assertTrue(bookInfoDoNotContainsName);
    }
}
