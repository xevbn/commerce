package com.example.commerce;

public class Item {
    private final Product product;
    private int quantity;

    public Item(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public String getName() {
        return product.getName();
    }

    public int getPrice() {
        return product.getPrice();
    }

    public int getQuantity() {
        return quantity;
    }

    public void increaseQuantity(int quantity) {
        this.quantity += quantity;
    }

    public Product getProduct() {
        return this.product;
    }

    public void decreaseStock() {
        product.decreaseStock(quantity);
    }
}
