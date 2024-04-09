package day02;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayQuiz03 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] nameList = {"영웅재중", "최강창민", "시아준수", "믹키유천", "유노윤호"};

        System.out.println("* 변경 전 정보: " + Arrays.toString(nameList));
        System.out.println("- 수정할 멤버의 이름을 입력하세요");

        while (true) {
            System.out.print(">> ");
            String selectName = scanner.nextLine();

            int index = -1;
            for (int i = 0; i < nameList.length; i++) {
                if(nameList[i].equals(selectName)) {
                    index = i;
                }
            }
            if (index == -1) {
                System.out.printf("%s은(는) 없는 이름입니다.\n", selectName);
            } else {
                    System.out.printf("%s의 이름을 변경합니다.\n", selectName);
                    System.out.print(">> ");
                    String editName = scanner.nextLine();
                    nameList[index] = editName;
                    System.out.println("변경 완료!!");
                    System.out.printf("변경 후 정보: " + Arrays.toString(nameList));
                    break;
                    }
        }
    }
}
