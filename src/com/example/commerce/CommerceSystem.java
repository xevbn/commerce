package com.example.commerce;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CommerceSystem {
    private ArrayList<Product> products;

    public CommerceSystem(ArrayList<Product> products) {
        this.products = products;
    }

    public void start() {
        Scanner sc = new Scanner(System.in);
        products.add(new Product("Galaxy S25", 1200000, "최신 안드로이도 핸드폰", 10));
        products.add(new Product("iPhone", 1350000, "Apple의 최신 스마트폰", 10));
        products.add(new Product("MacBook Pro", 2400000, "M3 칩셋이 탑재된 노트북", 10));
        products.add(new Product("AirPods Pro", 350000, "노이즈 캔슬링 무선 이어폰", 10));

        while(true) {
            try {
                System.out.println("[ 실시간 커머스 플랫폼 - 전자제품 ]");
                for (int i = 0; i < products.size(); i++) {
                    System.out.println(i+1 + " " + products.get(i).getName() + "\t| " +
                            String.format("%,d", products.get(i).getPrice()) + "원\t| " +
                            products.get(i).getDesc()
                    );
                }
                System.out.println("0. 종료");

                int input;
                input = sc.nextInt();

                System.out.println();
                if(input == 0) {
                    System.out.println("커머스 플랫폼을 종료합니다.");
                    break;
                } else if (input > products.size()) {
                    throw new IllegalArgumentException();
                } else {
                    getProductDetail(input - 1);
                }
            } catch(InputMismatchException e) {
                System.out.println("\n잘못된 입력입니다.\n");
                sc.next();      //nextInt() 같은 메서드는 값이 자료형과 맞지 않으면 scanner의 포인터가 움직이지 않는다.
            } catch(IllegalArgumentException e) {
                System.out.println("입력값이 상품 범위를 벗어났습니다.\n");
            }
        }
    }

    public void getProductDetail(int productId) {
        Product product = products.get(productId);
        System.out.println("선택한 상품: " + product.getName() +
                " | " + String.format("%,d", product.getPrice()) + " | " +
                product.getDesc() + " | " +
                "재고: " + product.getStock());
        System.out.println();
    }
}
