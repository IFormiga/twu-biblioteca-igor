package com.twu.biblioteca.models;

public class Book {
    private int Id;
    public boolean isCheckedOut;
    private String Name;
    private String Author;
    private int ReleaseYear;

    public Book(String name, String author, int releaseYear, int id) {
        this.Id = id;
        this.Name = name;
        this.Author = author;
        this.ReleaseYear = releaseYear;
        this.isCheckedOut = false;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public int getId(){
        return this.Id;
    }

    public String getName() {
        return Name;
    }

    public String getAuthor() {
        return Author;
    }

    public int getReleaseYear() {
        return ReleaseYear;
    }

    public String getBookInfo(){
        String bookInfo = new String();
        if(this.Name != null)
            bookInfo += "Name: " + this.getName() + " | ";
        if(this.Author != null)
            bookInfo += "Author: " + getAuthor() + " | " ;
        if(this.ReleaseYear > 0)
            bookInfo += "Release Year: " + getReleaseYear();
        return bookInfo;
    }

    @Override
    public boolean equals(Object obj) {
        if (((Book) obj).getAuthor().equals(this.Author) &&
            ((Book) obj).getName().equals(this.Name) &&
            ((Book) obj).getReleaseYear() == this.ReleaseYear)
            return true;

        return false;
    }
}
