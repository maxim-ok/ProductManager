package ru.netology.domain;

public class Book extends Product {
    private String bookName;
    private String author;

    public Book(int id, String productName, int price, String bookName, String author) {
        super(id, productName, price);
        this.bookName = bookName;
        this.author = author;
    }
}

