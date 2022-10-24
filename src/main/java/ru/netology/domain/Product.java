package ru.netology.domain;

public class Product {

    protected int id;
    protected String productName;
    protected int price;

    public Product(int id, String productName, int price) {
        this.id = id;
        this.productName = productName;
        this.price = price;
    }

    public String getName() {
        return productName;
    }

    public int getId() {
        return id;
    }
}
