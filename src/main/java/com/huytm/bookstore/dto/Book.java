/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huytm.bookstore.dto;

import java.io.Serializable;

/**
 *
 * @author acer
 */
public class Book implements Serializable{
    private String isbn;
    private String title;
    private String author;
    private int edition;
    private int publishedYear;

    public Book() {
    }

    public Book(String isbn, String title, String author, int edition, int publishedYear) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.edition = edition;
        this.publishedYear = publishedYear;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
    }

    @Override
    public String toString() {
        return String.format("|%13s|%-30s|%-30s|%4d|%4d|",
                isbn, title, author, edition, publishedYear);
    }
    
    public static void main(String[] args) {
        System.out.println(new Book("123", "Đời ngắn lắm đừng ngủ dài", "Japa", 1, 2019));
        System.out.println(new Book("124", "Tony buổi sáng", "Tony", 13, 2021));
    }
 
}
