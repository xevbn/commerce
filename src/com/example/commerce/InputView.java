package com.example.commerce;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    private int readInt() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner.next();
            throw new InputMismatchException();
        }
    }

    public int askCategoryNum(int categorySize, boolean cartIsEmpty) {
        int categoryNum = readInt() - 1;

        if(categoryNum == -1) {
            System.out.println("커머스 플랫폼을 종료합니다.");
            return -1;
        } else if(categoryNum == categorySize + 2) {
            return categoryNum;
        } else if (!cartIsEmpty && categoryNum > categorySize + 1) {
            throw new IllegalArgumentException();
        } else if (cartIsEmpty && categoryNum >= categorySize) {
            throw new IllegalArgumentException();
        }

        return categoryNum;
    }

    public int askSelectedProductNum(List<Product> products) {
        int productNum = readInt() - 1;

        if(productNum > products.size()) {
            throw new IllegalArgumentException();
        }
        return productNum;
    }

    public boolean askToAddCart() {
        int input =  readInt();

        if(input == 1) return true;
        else if(input == 2) return false;
        else throw new IllegalArgumentException();
    }

    public boolean askToOrder() {
        int commandNum = readInt();

        if(commandNum == 1) {
            return true;
        } else if(commandNum == 2) {
            return false;
        } else throw new IllegalArgumentException();
    }

    public String askAdminPassword() {
        return scanner.next();
    }

    public int askAdminMode() {
        int input = readInt();

        if(input > 4 || input < 0) {
            throw new IllegalArgumentException();
        }

        return input;
    }

    public int askAdminCategory(int categorySize) {
        int categoryNum = readInt() - 1;
        if(categoryNum > categorySize) {
            throw new IllegalArgumentException();
        }

        return categoryNum;
    }

    public String askAdminProductName() {
        return scanner.next();
    }

    public int askAdminProductPrice() {
        return readInt();
    }

    public String askAdminProductDescription() {
        return scanner.next();
    }

    public int askAdminProductStock() {
        return readInt();
    }

    public boolean askConfirmation() {
        int input  = readInt();

        if(input == 1)
            return true;
        else if(input == 2)
            return false;
        else
            throw new IllegalArgumentException();
    }

    public int askAdminEditItem() {
        int input =  readInt();

        if(input > 3 || input < 1)
            throw new IllegalArgumentException();

        return input;
    }

    public String askAdminEditProductName() {
        return scanner.next();
    }

    public int askAdminEditProductPrice() {
        return readInt();
    }
}
