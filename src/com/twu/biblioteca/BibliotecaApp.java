package com.twu.biblioteca;
import com.twu.biblioteca.models.Library;
import com.twu.biblioteca.resources.Constants;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.twu.biblioteca.resources.Constants.CHECKOUT_BOOK_UNSUCCESSFUL_MESSAGE;
import static com.twu.biblioteca.resources.Constants.RETURN_BOOK_UNSUCCESSFUL_MESSAGE;
import static org.mockito.Mockito.mock;

public class BibliotecaApp {

    private static Library biblioteca = new Library();
    private static BufferedReader _inputReader = new BufferedReader(new InputStreamReader(System.in));

    public BibliotecaApp(BufferedReader inputReader) {
        _inputReader = inputReader;
    }

    public static void main(String[] args) throws IOException {
        String menuOption = new String();
        displayWelcomeMessage();
        do {
            displayTheLibraryMenu();
            menuOption = _inputReader.readLine();
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
            case "3":
                returnBook();
                break;
            case "4":
                biblioteca.getAllMovies().stream().forEach(System.out::println);
                break;
            case Constants.QUIT_SYSTEM_KEYWORD:
                displayQuittingMessage();
                break;
            default:
                System.out.println(Constants.INVALID_OPTION_MESSAGE);
        }
    }

    private static void returnBook() {
        try{
            int bookId = requestTheBookId();
            boolean bookWasReturnedWithSuccess = biblioteca.returnBook(bookId);
            if(bookWasReturnedWithSuccess){
                displayReturnBookSuccessMessage();
            }
            else{
                displayReturnBooksUnsuccessfulMessage();
            }
        } catch(IOException e) {

        }
    }

    private static void displayReturnBookSuccessMessage() {
        System.out.println(Constants.RETURN_BOOK_SUCCESS_MESSAGE);
    }

    private static void displayReturnBooksUnsuccessfulMessage() {
        System.out.println(RETURN_BOOK_UNSUCCESSFUL_MESSAGE);
    }

    private static void checkoutBook() {
        displayTheCheckoutBookMessage();
        try{
            int bookId = requestTheBookId();
            boolean checkOutedWithSuccess = biblioteca.checkoutABook(bookId);
            if(checkOutedWithSuccess)
                displayCheckoutBookSuccessMessage();
            else
                System.out.println(CHECKOUT_BOOK_UNSUCCESSFUL_MESSAGE);
        } catch(IOException e) {

        }
    }
    public static void displayCheckoutBookSuccessMessage(){
        System.out.println(Constants.CHECKOUT_BOOK_SUCCESS_MESSAGE);
    }

    private static int requestTheBookId() throws IOException {
        return Integer.parseInt(_inputReader.readLine());
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
