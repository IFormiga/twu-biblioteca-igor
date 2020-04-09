package com.twu.biblioteca.models;

import java.util.ArrayList;

public class Biblioteca {
    private static String WelcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    private static ArrayList<String> Books = new ArrayList<String>(){{
        add("Clean Code");
        add("Refactoring: improving the design of existing code");
        add("Clean Architecture");
    }};

    public static ArrayList<String> getAllBooks() {
        return Books;
    }

    public String getWelcomeMessage() {
        return WelcomeMessage;
    }
}
