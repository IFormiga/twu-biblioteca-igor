package com.twu.biblioteca;


import com.twu.biblioteca.models.Library;
import com.twu.biblioteca.resources.Constants;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class LibraryTest {

    private Library biblioteca;

    @Before
    public void setupTest(){
        biblioteca = new Library();
    }

    @Test
    public void shouldGetTheCorrectWelcomeMessage() {
        String expectedMessage = Constants.WELCOME_MESSAGE;
        String message = this.biblioteca.getWelcomeMessage();

        assertEquals( expectedMessage, message);
    }

    @Test
    public void shouldBeAbleToCheckoutABook(){
        int bookId = 1;
        biblioteca.checkoutABook(bookId);

        assertTrue(biblioteca.getABookById(bookId).isCheckedOut());
    }

    @Test
    public void shouldListTheCorrectBooksInfo() {
        List<String> expectedLibraryBooksInfo = new ArrayList<String>();
        expectedLibraryBooksInfo.add("Name: Clean Code | Author: Robert Cecil Martin | Release Year: 2008");
        expectedLibraryBooksInfo.add("Name: Refactoring: improving the design of existing code | Author: Martin Fowler | Release Year: 1999");
        expectedLibraryBooksInfo.add("Name: Clean Architecture | Author: Robert Cecil Martin | Release Year: 2017");

        List allBooksInfo = biblioteca.getAllAvailableBooksInfo();

        assertEquals(expectedLibraryBooksInfo, allBooksInfo);
    }

    @Test
    public void shouldListAuthorsInTheLibraryBooksInfo() {
        boolean allBooksInfoHaveAuthors = biblioteca.getAllAvailableBooksInfo().stream().allMatch(b -> b.contains("Author"));

        assertTrue(allBooksInfoHaveAuthors);
    }

    @Test
    public void shouldHave2ColumnsInTheLibraryBooksInfo(){
        boolean allBooksInfoHaveColumnSeparators = biblioteca.getAllAvailableBooksInfo()
                .stream()
                .allMatch(b -> b.chars().filter(c -> c == '|').count() == 2);

        assertTrue(allBooksInfoHaveColumnSeparators);
    }

    @Test
    public void shouldListReleaseYearInTheLibraryBooks() {
        boolean allBooksInfoHaveReleaseYear = biblioteca.getAllAvailableBooksInfo().stream().allMatch(b -> b.contains("Release Year"));

        assertTrue(allBooksInfoHaveReleaseYear);
    }


    @Test
    public void shouldListOnlyAvailableBooks(){
        List<String> expectedLibraryAvailableBooksInfo = new ArrayList<String>();
        expectedLibraryAvailableBooksInfo.add("Name: Clean Code | Author: Robert Cecil Martin | Release Year: 2008");
        expectedLibraryAvailableBooksInfo.add("Name: Refactoring: improving the design of existing code | Author: Martin Fowler | Release Year: 1999");

        biblioteca.checkoutABook(3);
        List allBooksInfo = this.biblioteca.getAllAvailableBooksInfo();

        assertEquals(expectedLibraryAvailableBooksInfo, allBooksInfo);
    }
}
