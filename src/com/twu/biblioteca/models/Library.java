package com.twu.biblioteca.models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Library {
    private static String welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    private ArrayList<Book> books = new ArrayList<Book>(){{
        add(new Book("Clean Code", "Robert Cecil Martin", 2008, 1));
        add(new Book("Refactoring: improving the design of existing code", "Martin Fowler", 1999, 2));
        add(new Book("Clean Architecture", "Robert Cecil Martin", 2017, 3));
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




