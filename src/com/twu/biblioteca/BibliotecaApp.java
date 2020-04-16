package com.twu.biblioteca;
import com.twu.biblioteca.models.Library;

public class BibliotecaApp {

    private static Library Biblioteca;

    public static void main(String[] args) {
        Biblioteca = new Library();
        displayWelcomeMessage();
        displayAllTheBooksInfo();
    }

    private static void displayAllTheBooksInfo() {
        System.out.println("List of our books:");
        Biblioteca.getAllBooksInfo().stream().forEach(System.out::println);
    }

    private static void displayWelcomeMessage(){
        System.out.println(Biblioteca.getWelcomeMessage());
    }
}
