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
            scanner.nextLine();
            throw new InputMismatchException();
        }
    }

    public int askCategoryNum(int categorySize, boolean cartIsEmpty) {
        int categoryNum = readInt() - 1;

        if(categoryNum == -1) {
            System.out.println("커머스 플랫폼을 종료합니다.");
            return -1;
        } else if (!cartIsEmpty && categoryNum > categorySize + 1) {
            throw new IllegalArgumentException();
        } else if (cartIsEmpty && categoryNum > categorySize - 1) {
            throw new IllegalArgumentException();
        }

        return categoryNum;
    }

    public int askSelectedProductNum(List<Product> products) {
        int productNum = readInt();

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

    public boolean askToOrder(ShoppingCart cart) {
        int commandNum = readInt();

        if(commandNum == 1) {
            return true;
        } else if(commandNum == 2) {
            return false;
        } else throw new IllegalArgumentException();
    }
}
