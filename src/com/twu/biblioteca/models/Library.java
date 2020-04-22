package com.twu.biblioteca.models;

import com.twu.biblioteca.resources.Constants;

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

    public List<String> getAllAvailableBooksInfo() {
        return books.stream().filter(b -> b.isCheckedOut == false).map(b -> b.getBookInfo()).collect(Collectors.toList());
    }

    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    public void checkoutABook(int bookId){
        this.books.stream()
                .filter(b -> b.getId() == bookId && b.isCheckedOut() != true)
                .findFirst()
                .ifPresent(b -> b.isCheckedOut = true);
    }

    public Book getABookById(int bookId){
        return this.books.stream()
                .filter(b -> b.getId() == bookId)
                .findFirst()
                .orElse(null);
    }
}




