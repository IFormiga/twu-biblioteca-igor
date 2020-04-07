package com.twu.biblioteca.models;

public class Biblioteca {
    String WelcomeMessage;

    public Biblioteca(String welcomeMessage) {
        WelcomeMessage = welcomeMessage;
    }

    public String getWelcomeMessage() {
        return WelcomeMessage;
    }
}
