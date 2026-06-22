package com.example.commerce;

import java.util.List;

public class OutputView {
    public void printMainMenu(List<Category> categories) {
        System.out.println("[ 실시간 커머스 플랫폼 메인 ]");
        for(int i = 0; i < categories.size(); i++) {
            System.out.println((i + 1) + ". " + categories.get(i).getName());
        }
        System.out.println("0. 종료\n");
    }

    public void printOrderManagement() {
        System.out.println("[ 주문 관리 ]");
        System.out.println("4. 장바구니 확인");
        System.out.println("5. 주문 취소");
    }

    public void printProductList(String categoryName, List<Product> products) {
        System.out.println("\n[ " + categoryName + "카테고리 ]");
        for(int i = 0; i < products.size(); i++) {
            System.out.println(i+1 + " " + products.get(i).getName() + "\t| " +
                    String.format("%,d", products.get(i).getPrice()) + "원\t| " +
                    products.get(i).getDesc()
            );
        }
        System.out.println("0. 뒤로가기");
    }

    public void printProductDetail(Product product) {
        System.out.println("선택한 상품: " + product.getName() +
                " | " + String.format("%,d", product.getPrice()) + " | " +
                product.getDesc() + " | " +
                "재고: " + product.getStock());
        System.out.println();

        System.out.println("위 상품을 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인\t2. 취소");
    }

    public void printItemAddedToCart(String productName) {
        System.out.println(productName + "가 장바구니에 추가되었습니다.");
    }

    public void printShoppingCart(ShoppingCart cart) {
        System.out.println("아래와 같이 주문 하시겠습니까?");
        System.out.println("\n[ 장바구니 내역 ]");

        for(Item item : cart.getItems()) {
            Product product = item.getProduct();
            System.out.println(product.getName() + " | " +  String.format("%,d", product.getPrice()) + "원 | " +
                    product.getDesc() + " | 수랑: " + item.getQuantity() + "개");
        }

        System.out.println("\n[ 총 주문 금액 ]");
        System.out.println(String.format("%,d", cart.getTotalPrice())  + "원");

        System.out.println("1. 주문 확정\t2. 메인으로 돌아가기");
    }

    public void printTotalPrice(ShoppingCart cart) {
        System.out.println("주문이 완료되었습니다! 총 금액: " +String.format("%,d", cart.getTotalPrice()) + "원");
    }

    public void printStockChange(Item item) {
        Product product = item.getProduct();
        int quantity = item.getQuantity();

        System.out.println(product.getName() + " 재고가 " + product.getStock() + "개 -> "
                + (product.getStock() - quantity) + "개로 업데이트되었습니다.");
    }

    public void printOrderCancellation() {
        System.out.println("주문이 취소되었습니다.");
    }
}
