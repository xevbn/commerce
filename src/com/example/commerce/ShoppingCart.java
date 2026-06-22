package com.example.commerce;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private final List<Item> items = new ArrayList<>();

    public void addItem(Product product, int quantity) {
        items.add(new Item(product, quantity));
    }

    public List<Item> getItems() {
        return items.stream().toList();
    }

    public void clearItems() {
        items.clear();
    }

    public void purchase() {
        items.forEach(Item::decreaseStock);
        clearItems();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public int getTotalPrice() {
        return items.stream().mapToInt(Item::getPrice).sum();
    }
}
