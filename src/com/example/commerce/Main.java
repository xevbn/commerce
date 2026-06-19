package com.example.commerce;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Product> products = new ArrayList<>();
        products.add(new Product("Galaxy S25", 1200000, "최신 안드로이도 핸드폰", 10));
        products.add(new Product("iPhone", 1350000, "Apple의 최신 스마트폰", 10));
        products.add(new Product("MacBook Pro", 2400000, "M3 칩셋이 탑재된 노트북", 10));
        products.add(new Product("AirPods Pro", 350000, "노이즈 캔슬링 무선 이어폰", 10));

        while(true) {
            try {
                System.out.println("[ 실시간 커머스 플랫폼 - 전자제품 ]");
                for (int i = 0; i < products.size(); i++) {
                    System.out.println(i+1 + " " + products.get(i).getName() + "\t| " +
                            String.format("%,d", products.get(i).getPrice()) + "\t| " +
                            products.get(i).getDesc()
                    );
                }
                System.out.println("0. 종료");

                int input;
                input = sc.nextInt();

                if(input == 0) {
                    System.out.println("커머스 플랫폼을 종료합니다.");
                    break;
                } else if (input > products.size()) {
                    throw new IllegalArgumentException();
                } else {
                    Product product = products.get(input-1);
                    System.out.println("선택한 상품: " + product.getName() +
                            " | " + String.format("%,d", product.getPrice()) + " | " +
                            product.getDesc() + " | " +
                            "재고: " + product.getStock());
                    System.out.println();
                }
            } catch(InputMismatchException e) {
                System.out.println("잘못된 입력입니다.\n");
                sc.next();
            } catch(IllegalArgumentException e) {
                System.out.println("입력값이 상품 범위를 벗어났습니다.\n");
            }
        }
    }
}
