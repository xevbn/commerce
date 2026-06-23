package com.example.commerce;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class OutputView {
    public void printMainMenu(List<Category> categories) {
        System.out.println("[ 실시간 커머스 플랫폼 메인 ]");
        for(int i = 0; i < categories.size(); i++) {
            System.out.println((i + 1) + ". " + categories.get(i).getName());
        }
        System.out.println("0. 종료");
        System.out.println("6. 관리자 모드");
    }

    public void printOrderManagement() {
        System.out.println("\n[ 주문 관리 ]");
        System.out.println("4. 장바구니 확인");
        System.out.println("5. 주문 취소");
    }

    public void printProductList(String categoryName, List<Product> products, boolean back) {
        System.out.println("\n[ " + categoryName + "카테고리 ]");
        for(int i = 0; i < products.size(); i++) {
            System.out.println(i+1 + " " + products.get(i).getName() + "\t | " +
                    String.format("%,d", products.get(i).getPrice()) + "원\t | " +
                    products.get(i).getDesc()
            );
        }
        if(back)
            System.out.println("0. 뒤로가기");
    }

    public void printProductsAllInfo(String categoryName, List<Product> products) {
        System.out.println("\n[ " + categoryName + "카테고리 ]");
        for(int i = 0; i < products.size(); i++) {
            System.out.println(i+1 + " " + products.get(i).getName() + "\t | " +
                    String.format("%,d", products.get(i).getPrice()) + "원\t | " +
                    products.get(i).getDesc()+ " | " +
                    "재고: " + products.get(i).getStock()
            );
        }
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
        System.out.println(productName + "가 장바구니에 추가되었습니다.\n");
    }

    public void printShoppingCart(ShoppingCart cart) {
        System.out.println("아래와 같이 주문 하시겠습니까?");
        System.out.println("\n[ 장바구니 내역 ]");

        for(Item item : cart.getItems()) {
            Product product = item.getProduct();
            System.out.println(product.getName() + " | "
                    + String.format("%,d", product.getPrice()) + "원 | " +
                    product.getDesc() + " | 수랑: " + item.getQuantity() + "개");
        }

        System.out.println("\n[ 총 주문 금액 ]");
        System.out.println(String.format("%,d", cart.getTotalPrice())  + "원");

        System.out.println("1. 주문 확정\t2. 메인으로 돌아가기");
    }

    public void printTotalPrice(ShoppingCart cart) {
        System.out.println("주문이 완료되었습니다! 총 금액: " +
                String.format("%,d", cart.getTotalPrice()) + "원\n");
    }

    public void printStockChange(Item item) {
        Product product = item.getProduct();
        int quantity = item.getQuantity();

        System.out.println(product.getName() + " 재고가 " + product.getStock() + "개 -> "
                + (product.getStock() - quantity) + "개로 업데이트되었습니다.\n");
    }

    public void printOrderCancellation() {
        System.out.println("주문이 취소되었습니다.\n");
    }

    public void printAdminValidation() {
        System.out.println("관리자 비밀번호를 입력해주세요:");
    }

    public void printPasswordIncorrect() {
        System.out.println("비밀번호가 일치하지 않습니다.\n");
    }

    public void printAdminMode() {
        System.out.println("\n[ 관리자 모드 ]");
        System.out.println("1. 상품 추가");
        System.out.println("2. 상품 수정");
        System.out.println("3. 상품 삭제");
        System.out.println("4. 전체 상품 현황");
        System.out.println("0. 메인으로 돌아가기");
    }

    public void printCategoryProductAdd(List<Category> categories) {
        System.out.println("어느 카테고리에 상품을 추가하시겠습니까?");
        AtomicInteger i = new AtomicInteger(1);
        categories.forEach(category -> {
            System.out.println(i.getAndIncrement() + ". " +  category.getName());
            return;
        });
    }

    public void printCategoryAddProductDetail(Category category) {
        System.out.println("\n[ " + category.getName() + "에 상품 추가 ]");
        System.out.println("상품명을 입력해주세요: ");
    }

    public void printPriceInput() {
        System.out.println("가격을 입력해주세요: ");
    }

    public void printDescInput() {
        System.out.println("상품 설명을 입력해주세요: ");
    }

    public void printStockInput() {
        System.out.println("재고수량을 입력해주세요: ");
    }

    public void printAllProducts(List<Category> categories) {
        categories.forEach(category ->
                printProductsAllInfo(category.getName(), category.getProducts())
        );
    }

    public void printAddProductDetail(Product product) {
        System.out.println(product.getName() +
                " | " + String.format("%,d", product.getPrice()) + " | " +
                product.getDesc() + " | " +
                "재고: " + product.getStock());
        System.out.println("위 상품을 추가하시겠습니까?");
        System.out.println("1. 확인\t2. 취소");
    }

    public void printAddSuccess() {
        System.out.println("상품이 성공적으로 추가되었습니다!\n");
    }

    public void printAskEditProduct() {
        System.out.println("수정할 상품명을 입력해주세요: ");
    }

    public void printAskEditInfo() {
        System.out.println("수정할 항목을 선택해주세요:");
        System.out.println("1. 가격");
        System.out.println("2. 설명");
        System.out.println("3. 재고수량");
    }

    public void printEditPrice(int price) {
        System.out.println("현재 가격: " + String.format("%,d", price) + "원");
        System.out.println("새로운 가격을 입력해주세요: ");
    }

    public void printEditDesc(String desc) {
        System.out.println("현재 상품 설명: " + desc);
        System.out.println("새로운 설명을 입력해주세요: ");
    }

    public void printEditStock(int stock) {
        System.out.println("현재 상품 재고수량: " + stock);
        System.out.println("새로운 재고수량을 입력해주세요: ");

    }

    public void print(String str) {
        System.out.println(str);
    }

    public void printEditSuccess(String productName, String what, String old, String edited) {
        System.out.println(productName + "의 " + what + "이 " + old + " -> " + edited + "로 수정되었습니다.");
    }

    public void printAskDeleteProduct() {
        System.out.println("삭제할 상품명을 입력해주세요: ");
    }

    public void printDeleteConfirmation(Product product) {
        System.out.println(product.getName() +
                " | " + String.format("%,d", product.getPrice()) + " | " +
                product.getDesc() + " | " +
                "재고: " + product.getStock());
        System.out.println("위 상품을 삭제하시겠습니까?");
        System.out.println("1. 확인\t2. 취소");
    }

    public void printDeleteSuccess() {
        System.out.println("상품이 삭제되었습니다.\n");
    }
}
