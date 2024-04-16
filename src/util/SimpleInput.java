package util;

import java.util.Scanner;

// 역할: 스캐너 입력을 간소화해주는 객체
public class SimpleInput {

    Scanner sc = new Scanner(System.in);

    public String input(String message) {
        System.out.print(message);
        return sc.nextLine();
    }
}
