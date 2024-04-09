package day02;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayQuiz01 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] foodList = new String[1];
//        System.out.println("foodList = " + Arrays.toString(foodList));
        System.out.println("# 먹고 싶은 음식을 입력하세요!!");
        System.out.println("# 입력을 중지하려면 <그만>이라고 입력하세요.");

//        int i = 0;

        while (true) {
            System.out.print(">> ");
            String food = scanner.nextLine();
            if (food.equals("그만")) {
                System.out.println("먹고 싶은 음식 리스트: " + Arrays.toString(foodList) );
                break;
            } else if(foodList[0] == null) {
                foodList[0] = food;
            } else {
                String[] temp = new String[foodList.length + 1];
                for (int j = 0; j < foodList.length; j++) {
                    temp[j] = foodList[j];
                }
                temp[foodList.length] = food;
                foodList = temp;
            }
        }
    }
}
