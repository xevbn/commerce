package com.example.commerce;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        CommerceSystem commerceSystem = new CommerceSystem(new ArrayList<>(), new ShoppingCart());
        commerceSystem.start();
    }
}
