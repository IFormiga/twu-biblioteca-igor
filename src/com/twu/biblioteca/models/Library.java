package com.twu.biblioteca.models;

import com.twu.biblioteca.resources.Constants;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Library {
    private static String welcomeMessage = Constants.WELCOME_MESSAGE;
    private ArrayList<Book> books = new ArrayList<Book>(){{
        add(new Book(Constants.FIRST_BOOK_EXAMPLE_NAME, Constants.FIRST_BOOK_EXAMPLE_AUTHOR, Constants.FIRST_BOOK_EXAMPLE_RELEASE_YEAR, 1));
        add(new Book(Constants.SECOND_BOOK_EXAMPLE_NAME, Constants.SECOND_BOOK_EXAMPLE_AUTHOR, Constants.SECOND_BOOK_EXAMPLE_RELEASE_YEAR, 2));
        add(new Book(Constants.THIRD_BOOK_EXAMPLE_NAME, Constants.THIRD_BOOK_EXAMPLE_AUTHOR, Constants.THIRD_BOOK_EXAMPLE_RELEASE_YEAR, 3));
    }};
    private ArrayList<String> movies = new ArrayList<String>(){{
       add("Name: The Matrix | Year: 1999 | Director: Wachowski Sisters | Rating: 10");
       add("Name: The Matrix Reloaded | Year: 2003 | Director: Wachowski Sisters | Rating: 8");
       add("Name: The Matrix Revolutions | Year: 2003 | Director: Wachowski Sisters | Rating: 9");
    }};

    public List<String> getAllAvailableBooksInfo() {
        return books.stream().filter(b -> b.isCheckedOut == false).map(b -> b.getBookInfo()).collect(Collectors.toList());
    }

    public String getWelcomeMessage() {
        return welcomeMessage;
    }                                                                                 

    public boolean checkoutABook(int bookId){
        if(checkIfTheBookExistsAndIsAvailableToCheckout(bookId)){
            this.books.stream()
                    .filter(b -> b.getId() == bookId && b.isCheckedOut() != true)
                    .findFirst()
                    .ifPresent(b -> b.isCheckedOut = true);
            return true;
        }
        else {
            return false;
        }
    }

    private boolean checkIfTheBookExistsAndIsAvailableToCheckout(int bookId) {
        return this.books.stream().anyMatch(b -> b.getId() == bookId && b.isCheckedOut() != true);
    }

    private boolean checkIfTheBookExistsAndItsCheckedOut(int bookId){
        return this.books.stream().anyMatch(b -> b.getId() == bookId && b.isCheckedOut() == true);
    }

    public Book getABookById(int bookId){
        return this.books.stream()
                .filter(b -> b.getId() == bookId)
                .findFirst()
                .orElse(null);
    }

    public boolean returnBook(int bookId){
        if(checkIfTheBookExistsAndItsCheckedOut(bookId)) {
            getABookById(bookId).isCheckedOut = false;
            return true;
        }
        else{
            return false;
        }
    }

    public ArrayList<String> getAllMovies() {
        return this.movies;
    }
}




