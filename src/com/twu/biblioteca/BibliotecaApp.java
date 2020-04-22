package com.twu.biblioteca;
import com.sun.tools.internal.jxc.ap.Const;
import com.twu.biblioteca.models.Library;
import com.twu.biblioteca.resources.Constants;

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
        return menuOption.equals(Constants.QUIT_SYSTEM_KEYWORD);
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
            case Constants.QUIT_SYSTEM_KEYWORD:
                displayQuittingMessage();
                break;
            default:
                System.out.println(Constants.INVALID_OPTION_MESSAGE);
        }
    }

    private static void checkoutBook() {
        displayTheCheckoutBookMessage();
        try{
            int bookId = requestTheBookId();
            biblioteca.checkoutABook(bookId);
            displayCheckoutBookSuccessMessage();
        } catch(IOException e) {

        }
    }
    public static void displayCheckoutBookSuccessMessage(){
        System.out.println(Constants.CHECKOUT_BOOK_SUCCESS_MESSAGE);
    }

    private static int requestTheBookId() throws IOException {
        return Integer.parseInt(inputReader.readLine());
    }

    private static void displayTheCheckoutBookMessage() {
        System.out.printf(Constants.CHECKOUT_BOOK_MESSAGE);
    }

    private static void displayQuittingMessage() {
        System.out.println(Constants.QUITTING_MESSAGE);
    }

    public static void displayWelcomeMessage() {
        System.out.println(biblioteca.getWelcomeMessage());
    }

    public static void displayTheLibraryMenu() {
        System.out.println(Constants.LIBRARY_MENU);
    }
}
