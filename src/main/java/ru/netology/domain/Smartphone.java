package ru.netology.domain;

public class Smartphone extends Product {
    private String phoneName;
    private String producer;


    public Smartphone(int id, String productName, int price, String phoneName, String producer) {
        super(id, productName, price);
        this.phoneName = phoneName;
        this.producer = producer;
    }
}


