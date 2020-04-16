package com.twu.biblioteca;


import com.twu.biblioteca.models.Library;
import com.twu.biblioteca.models.Book;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class LibraryTest {

    private Library biblioteca;

    @Before
    public void SetupTest(){
        biblioteca = new Library();
    }

    @Test
    public void shouldGetTheCorrectWelcomeMessage() {
        String expectedMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
        String message = this.biblioteca.getWelcomeMessage();

        assertEquals( expectedMessage, message);
    }

    @Test
    public void shouldListTheCorrectBooksInfo() {
        List<String> expectedLibraryBooksInfo = new ArrayList<String>();
        expectedLibraryBooksInfo.add("Name: Clean Code | Author: Robert Cecil Martin | Release Year: 2008");
        expectedLibraryBooksInfo.add("Name: Refactoring: improving the design of existing code | Author: Martin Fowler | Release Year: 1999");
        expectedLibraryBooksInfo.add("Name: Clean Architecture | Author: Robert Cecil Martin | Release Year: 2017");

        List allBooksInfo = this.biblioteca.getAllBooksInfo();

        assertEquals(expectedLibraryBooksInfo, allBooksInfo);
    }

    @Test
    public void shouldListAuthorsInTheLibraryBooksInfo() {
        boolean allBooksInfoHaveAuthors = biblioteca.getAllBooksInfo().stream().allMatch(b -> b.contains("Author"));

        assertTrue(allBooksInfoHaveAuthors);
    }

    @Test
    public void shouldHave2ColumnsInTheLibraryBooksInfo(){
        boolean allBooksInfoHaveColumnSeparators = biblioteca.getAllBooksInfo()
                .stream()
                .allMatch(b -> b.chars().filter(c -> c == '|').count() == 2);

        assertTrue(allBooksInfoHaveColumnSeparators);
    }

    @Test
    public void shouldListReleaseYearInTheLibraryBooks() {
        boolean allBooksInfoHaveReleaseYear = biblioteca.getAllBooksInfo().stream().allMatch(b -> b.contains("Release Year"));

        assertTrue(allBooksInfoHaveReleaseYear);
    }
}
