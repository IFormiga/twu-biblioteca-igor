package com.twu.biblioteca;
import com.twu.biblioteca.models.Library;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BibliotecaApp {

    private static Library Biblioteca = new Library();;
    private static BufferedReader inputReader =
            new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        displayWelcomeMessage();
        displayTheLibraryMenu();
        String menuOption = inputReader.readLine();
        selectAMenuOption(menuOption);
    }

    public static void displayAllTheBooksInfo() {
        System.out.println("List of our books:");
        Biblioteca.getAllBooksInfo().stream().forEach(System.out::println);
    }

    public static void selectAMenuOption(String menuOption) {
        switch (menuOption){
            case "1":
                displayAllTheBooksInfo();
                break;
            default:
                System.out.println("Invalid Option.");
        }
    }

    public static void displayWelcomeMessage(){
        System.out.println(Biblioteca.getWelcomeMessage());
    }

    public static void displayTheLibraryMenu(){
        System.out.println("Biblioteca Menu\n1) Access the book list.");
    }
}
