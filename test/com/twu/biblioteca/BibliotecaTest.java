package com.twu.biblioteca;


import com.twu.biblioteca.models.Biblioteca;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BibliotecaTest {

    private Biblioteca biblioteca;

    @Before
    public void SetupTest(){
        biblioteca = new Biblioteca();
    }

    @Test
    public void checkIfWelcomeMessageIsCorrect() {
        String expectedMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
        String message = this.biblioteca.getWelcomeMessage();

        assertEquals( expectedMessage, message);
    }

    @Test
    public void checkThatTheBooksListingIsCorrect(){
        ArrayList<String> expectedLibraryBooks = new ArrayList<String>(){{
            add("Clean Code");
            add("Refactoring: improving the design of existing code");
            add("Clean Architecture");
        }};
        ArrayList<String> libraryBooks = Biblioteca.getAllBooks();
        assertEquals(expectedLibraryBooks, libraryBooks);
    }
}
