package com.twu.biblioteca.models;

public class Book {
    private int id;
    public boolean isCheckedOut;
    private String name;
    private String author;
    private int releaseYear;

    public Book(String name, String author, int releaseYear, int id) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.releaseYear = releaseYear;
        this.isCheckedOut = false;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public int getId(){
        return this.id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public String getBookInfo(){
        String bookInfo = new String();
        if(this.name != null)
            bookInfo += "Name: " + this.getName() + " | ";
        if(this.author != null)
            bookInfo += "Author: " + getAuthor() + " | " ;
        if(this.releaseYear > 0)
            bookInfo += "Release Year: " + getReleaseYear();
        return bookInfo;
    }

    @Override
    public boolean equals(Object obj) {
        if (((Book) obj).getAuthor().equals(this.author) &&
            ((Book) obj).getName().equals(this.name) &&
            ((Book) obj).getReleaseYear() == this.releaseYear)
            return true;

        return false;
    }
}
