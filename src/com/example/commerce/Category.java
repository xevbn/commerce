package com.example.commerce;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private final String name;
    private final List<Product> products = new ArrayList<>();

    public Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Product> getProducts() {
        return products.stream().toList();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void deleteProduct(Product product) {
        products.remove(product);
    }
}
