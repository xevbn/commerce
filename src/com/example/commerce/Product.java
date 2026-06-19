package com.example.commerce;

public class Product {
    private String name;
    private int price;
    private String desc;
    private int stock;

    public Product(String name, int price, String desc, int stock) {
        this.name = name;
        this.price = price;
        this.desc = desc;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    /*
    상태만 반환할 건지
    재고 없는 상황같은 경우에서 예외를 던지는 로직 등을 포함할건지
     */
}
