package com.twu.biblioteca;
import com.twu.biblioteca.models.Library;

public class BibliotecaApp {

    private static Library Biblioteca;

    public static void main(String[] args) {
        Biblioteca = new Library();
        displayWelcomeMessage();
        displayTheLibraryMenu();
        displayAllTheBooksInfo();
    }

    public static void displayAllTheBooksInfo() {
        System.out.println("List of our books:");
        Biblioteca.getAllBooksInfo().stream().forEach(System.out::println);
    }

    public static void displayWelcomeMessage(){
        System.out.println(Biblioteca.getWelcomeMessage());
    }

    public static void displayTheLibraryMenu(){
        System.out.println("Biblioteca Menu\n1) Access the book list.");
    }
}
