package com.example.commerce;

public class Admin {
    private String password;

    public Admin(String password) {
        this.password = password;
    }

    public boolean authenticate(String password) {
        return this.password.equals(password);
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
