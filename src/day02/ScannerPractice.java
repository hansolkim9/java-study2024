package day02;

import java.util.Scanner;

public class ScannerPractice {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("**** 상품 재고 총액 구하기 ****");
        System.out.print("- 상품의 가격: ");
        int itemPrice = Integer.parseInt(scan.nextLine());

        System.out.print("- 상품의 수량: ");
        int itemAmount = Integer.parseInt(scan.nextLine());

        int totalPrice = itemPrice * itemAmount;

        System.out.printf("--------------------\n상품 재고 총액 : %d원\n", totalPrice);

    }
}
