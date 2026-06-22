package com.example.commerce;

import javax.sound.sampled.Port;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CommerceSystem {
    private List<Category> categories;

    public CommerceSystem(List<Category> categories) {
        this.categories = categories;
    }

    public void setInitialValues() {
        Category electronics = new Category("전자제품");
        electronics.addProduct(new Product("Galaxy S25", 1200000, "최신 안드로이도 핸드폰", 10));
        electronics.addProduct(new Product("iPhone", 1350000, "Apple의 최신 스마트폰", 10));
        electronics.addProduct(new Product("MacBook Pro", 2400000, "M3 칩셋이 탑재된 노트북", 10));
        electronics.addProduct(new Product("AirPods Pro", 350000, "노이즈 캔슬링 무선 이어폰", 10));
        categories.add(electronics);

        Category clothes = new Category("의류");
        clothes.addProduct(new Product("나이키 바람막이", 139000, "가볍고 기능성이 뛰어난 스포츠 재킷", 30));
        clothes.addProduct(new Product("리바이스 501", 129000, "클래식한 스트레이트 핏 데님 팬츠", 35));
        clothes.addProduct(new Product("파타고니아 플리스", 229000, "친환경 소재의 따뜻한 보아털 집업", 40));
        clothes.addProduct(new Product("아디다스 삼바", 139000, "어디에나 잘 어울리는 데일리 스니커즈", 20));
        categories.add(clothes);

        Category food = new Category("식품");
        food.addProduct(new Product("한우 등심 스테이크", 45000, "마블링이 우수한 1등급 냉장 소고기", 50));
        food.addProduct(new Product("감바스 알 아히요", 16900, "탱글한 새우와 마늘향이 가득한 밀키트", 45));
        food.addProduct(new Product("유기농 샐러드 팩", 9800, "신선한 채소와 드레싱이 포함된 샐러드", 60));
        food.addProduct(new Product("제주 애플망고 세트", 89000, "당도가 높고 과즙이 풍부한 프리미엄 과일", 60));
        categories.add(food);
    }

    public void start() {
        Scanner sc = new Scanner(System.in);
        setInitialValues();

        while(true) {
            try {
                System.out.println("[ 실시간 커머스 플랫폼 메인 ]");
                for(int i = 0; i < categories.size(); i++) {
                    System.out.println((i + 1) + ". " + categories.get(i).getName());
                }
                System.out.println("0. 종료");

                int categoryNum = sc.nextInt();

                if(categoryNum == 0) {
                    System.out.println("커머스 플랫폼을 종료합니다.");
                    break;
                } else if (categoryNum > categories.size()) {
                    throw new IllegalArgumentException();
                } else {
                    Category selectedCategory = categories.get(categoryNum - 1);
                    System.out.println("\n[ " + selectedCategory.getName() + "카테고리 ]");
                    List<Product> products = selectedCategory.getProducts();
                    printProducts(products, sc);
                }
            } catch(InputMismatchException e) {
                System.out.println("\n잘못된 입력입니다.\n");
                sc.next();      //nextInt() 같은 메서드는 값이 자료형과 맞지 않으면 scanner의 포인터가 움직이지 않는다.
            } catch(IllegalArgumentException e) {
                System.out.println("입력값이 범위를 벗어났습니다.\n");
            }
        }
    }

    public void getProductDetail(List<Product> products, int productId) {
        Product product = products.get(productId);
        System.out.println("선택한 상품: " + product.getName() +
                " | " + String.format("%,d", product.getPrice()) + " | " +
                product.getDesc() + " | " +
                "재고: " + product.getStock());
        System.out.println();
    }

    public void printProducts(List<Product> products, Scanner sc) {
        for(int i = 0; i < products.size(); i++) {
            System.out.println(i+1 + " " + products.get(i).getName() + "\t| " +
                    String.format("%,d", products.get(i).getPrice()) + "원\t| " +
                    products.get(i).getDesc()
            );
        }
        System.out.println("0. 뒤로가기");

        int productNum = sc.nextInt();
        if(productNum == 0) {
            return;
        } else if(productNum > products.size()) {
            throw new IllegalArgumentException();
        } else {
            getProductDetail(products,  productNum);
        }
    }
}
