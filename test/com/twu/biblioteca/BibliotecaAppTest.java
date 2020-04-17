package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class BibliotecaAppTest {
    private BibliotecaApp bibliotecaApp;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setup(){
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void tearDown(){
        System.setOut(originalOut);
    }

    @Test
    public void shouldDisplayMenuCorrectly(){
        // expected
        String menuPrintedAsExpected = "Biblioteca Menu\n1) Access the book list.\n";
        // actual data
        bibliotecaApp.displayTheLibraryMenu();
        //assert
        assertEquals(menuPrintedAsExpected, outContent.toString());
    }
    //shouldAllowTheUserToChooseOption1
    @Test
    public void shouldAllowTheUserToChooseOption1(){
        String expectedOutput = "List of our books:\n" +
                                "Name: Clean Code | Author: Robert Cecil Martin | Release Year: 2008\n" +
                                "Name: Refactoring: improving the design of existing code | Author: Martin Fowler | Release Year: 1999\n" +
                                "Name: Clean Architecture | Author: Robert Cecil Martin | Release Year: 2017\n";

        bibliotecaApp.selectAMenuOption("1");
        assertEquals(expectedOutput, outContent.toString());
    }
}
