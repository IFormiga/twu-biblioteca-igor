package com.twu.biblioteca;

import com.twu.biblioteca.resources.Constants;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BibliotecaAppTest {
    private BufferedReader inputReader;
    private BibliotecaApp bibliotecaApp;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setup(){
        System.setOut(new PrintStream(outContent));
        inputReader = mock(BufferedReader.class);
        bibliotecaApp = new BibliotecaApp(inputReader);
    }

    @After
    public void tearDown(){
        System.setOut(originalOut);
    }

    @Test
    public void shouldBeAbleToQuitTheApplication(){
        String expectedMessageAfterQuitting = Constants.QUITTING_MESSAGE +"\n";
        bibliotecaApp.selectAMenuOption("Quit");

        assertEquals(expectedMessageAfterQuitting, outContent.toString());
    }

    @Test
    public void shouldDisplayMenuCorrectly(){
        // expected
        String menuPrintedAsExpected = Constants.LIBRARY_MENU + "\n";
        // actual data
        bibliotecaApp.displayTheLibraryMenu();
        //assert
        assertEquals(menuPrintedAsExpected, outContent.toString());
    }

    @Test
    public void shouldAllowTheUserToChooseOption1(){
        String expectedOutput = "List of our books:\n" +
                                "Id: 1 | Name: Clean Code | Author: Robert Cecil Martin | Release Year: 2008\n" +
                                "Id: 2 | Name: Refactoring: improving the design of existing code | Author: Martin Fowler | Release Year: 1999\n" +
                                "Id: 3 | Name: Clean Architecture | Author: Robert Cecil Martin | Release Year: 2017\n";

        bibliotecaApp.selectAMenuOption("1");
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void shouldDisplayASuccessMessageWhenCheckoutABookSuccessfully(){
        String expectedOutput = Constants.CHECKOUT_BOOK_SUCCESS_MESSAGE + "\n";
        bibliotecaApp.displayCheckoutBookSuccessMessage();

        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void shouldShowErrorMessageIfOptionDoNotExist(){
        String expectedOutput = Constants.INVALID_OPTION_MESSAGE + "\n";

        bibliotecaApp.selectAMenuOption("whatever");
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void shouldDisplayTheCorrectWelcomeMessage(){
        String expectedMessage = Constants.WELCOME_MESSAGE + "\n";

        bibliotecaApp.displayWelcomeMessage();
        assertEquals(expectedMessage, outContent.toString());
    }

    @Test
    public void shouldDisplayAnUnsuccessfulMessageWhenCheckoutABookFails() throws IOException {
        String expectedOutput = Constants.CHECKOUT_BOOK_UNSUCCESSFUL_MESSAGE;

        when(inputReader.readLine()).thenReturn("99999");
        bibliotecaApp.selectAMenuOption("2");

        assertTrue(outContent.toString().contains(expectedOutput));
    }

    @Test
    public void shouldListAsAvailableCheckOutedBookAfterBeingReturned() throws IOException {
        String expectedOutput = "List of our books:\n" +
                "Id: 1 | Name: Clean Code | Author: Robert Cecil Martin | Release Year: 2008\n" +
                "Id: 2 | Name: Refactoring: improving the design of existing code | Author: Martin Fowler | Release Year: 1999\n" +
                "Id: 3 | Name: Clean Architecture | Author: Robert Cecil Martin | Release Year: 2017\n";
        simulateABookCheckout();
        simulateABookReturn();
        outContent.reset();
        when(inputReader.readLine()).thenReturn("1");
        bibliotecaApp.selectAMenuOption("1");

        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void shouldDisplayASuccessMessageWhenReturnABookSuccessfully() throws IOException {
        String expectedOutput = Constants.RETURN_BOOK_SUCCESS_MESSAGE + "\n";

        simulateABookCheckout();
        outContent.reset();
        simulateABookReturn();

        when(inputReader.readLine()).thenReturn("1");
        bibliotecaApp.selectAMenuOption("3");

        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void shouldDisplayAMovieListWhenChooseTheOption() {
        String expectedMovieList = "Name: The Matrix | Year: 1999 | Director: Wachowski Sisters | Rating: 10\n"
            +"Name: The Matrix Reloaded | Year: 2003 | Director: Wachowski Sisters | Rating: 8\n"
            +"Name: The Matrix Revolutions | Year: 2003 | Director: Wachowski Sisters | Rating: 9\n";

        bibliotecaApp.selectAMenuOption("4");

        assertEquals(expectedMovieList, outContent.toString());
    }

    private void simulateABookReturn() throws IOException {
        when(inputReader.readLine()).thenReturn("1");
        bibliotecaApp.selectAMenuOption("3");
    }
    private void simulateABookCheckout() throws IOException {
        when(inputReader.readLine()).thenReturn("1");
        bibliotecaApp.selectAMenuOption("2");
    }

}
