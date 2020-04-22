package com.twu.biblioteca;
import com.twu.biblioteca.models.Library;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BibliotecaApp {

    private static Library biblioteca = new Library();
    private static BufferedReader inputReader =
            new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String menuOption = new String();
        displayWelcomeMessage();
        do {
            displayTheLibraryMenu();
            menuOption = inputReader.readLine();
            selectAMenuOption(menuOption);

        } while(!checkIfApplicationShouldQuit(menuOption));
    }

    private static boolean checkIfApplicationShouldQuit(String menuOption) {
        return menuOption.equals("Quit");
    }

    public static void displayAllTheBooksInfo() {
        System.out.println("List of our books:");
        biblioteca.getAllAvailableBooksInfo().stream().forEach(System.out::println);
    }

    public static void selectAMenuOption(String menuOption) {
        switch (menuOption){
            case "1":
                displayAllTheBooksInfo();
                break;
            case "2":
                checkoutBook();
                break;
            case "Quit":
                displayQuittingMessage();
                break;
            default:
                System.out.println("Please select a valid option!");
        }
    }

    private static void checkoutBook() {
        displayTheCheckoutBookMessage();
        try{
            int bookId = requestTheBookId();
            biblioteca.checkoutABook(bookId);
        } catch(IOException e) {

        }
    }

    private static int requestTheBookId() throws IOException {
        return Integer.parseInt(inputReader.readLine());
    }

    private static void displayTheCheckoutBookMessage() {
        System.out.printf("Insert the book Id: ");
    }

    private static void displayQuittingMessage() {
        System.out.println("Goodbye!");
    }

    public static void displayWelcomeMessage() {
        System.out.println(biblioteca.getWelcomeMessage());
    }

    public static void displayTheLibraryMenu() {
        System.out.println("Biblioteca Menu\n1) Access the book list.\n2) Checkout a book.\n Insert Quit at any time to leave.");
    }
}
