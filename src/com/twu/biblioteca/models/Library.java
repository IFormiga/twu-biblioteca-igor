package com.twu.biblioteca.models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Library {
    private static String WelcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    private static ArrayList<Book> Books = new ArrayList<Book>(){{
        add(new Book("Clean Code", "Robert Cecil Martin", 2008));
        add(new Book("Refactoring: improving the design of existing code", "Martin Fowler", 1999));
        add(new Book("Clean Architecture", "Robert Cecil Martin", 2017));
    }};

    public List<String> getAllBooksInfo() {
        return Books.stream().map(b -> b.getBookInfo()).collect(Collectors.toList());
    }

    public String getWelcomeMessage() {
        return WelcomeMessage;
    }
}




