package com.twu.biblioteca;
import com.twu.biblioteca.models.Biblioteca;

public class BibliotecaApp {

    private static Biblioteca Biblioteca;

    public static void main(String[] args) {
        Biblioteca = new Biblioteca();
        System.out.println(Biblioteca.getWelcomeMessage());
    }
}
