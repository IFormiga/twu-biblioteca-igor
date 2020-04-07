package com.twu.biblioteca;
import com.twu.biblioteca.models.Biblioteca;

public class BibliotecaApp {

    private static Biblioteca Biblioteca;

    public static void main(String[] args) {
        Biblioteca = new Biblioteca("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
        System.out.println(Biblioteca.getWelcomeMessage());
    }
}
