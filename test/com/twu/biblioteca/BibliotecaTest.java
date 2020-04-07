package com.twu.biblioteca;


import com.sun.codemodel.internal.JMethod;
import com.twu.biblioteca.models.Biblioteca;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BibliotecaTest {

    Biblioteca biblioteca;

    @Before
    public void SetupTest(){
        biblioteca = new Biblioteca("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }

    @Test
    public void checkIfWelcomeMessageIsCorrect() {
        String expectedMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
        String message = this.biblioteca.getWelcomeMessage();

        assertEquals( expectedMessage, message);
    }
}
