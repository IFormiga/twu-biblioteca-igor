package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

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
}
