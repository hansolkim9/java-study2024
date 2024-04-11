package day03;

import java.util.Arrays;

public class MethodQuiz {

    static String[] foods = {"떡볶이", "치킨", "파스타"};
    static String[] userNames = {"홍길동", "고길동"};

    static void printFoods() {
        System.out.println(Arrays.toString(foods));
    }
    static void push(String food) {
        String[] temp = new String[foods.length + 1];
        for (int i = 0; i < foods.length; i++) {
            temp[i] = foods[i];
        }
        temp[temp.length - 1] = food;
        foods = temp;
    }
    static int indexOf(String food) {
        int index = -1;
        for (int i = 0; i < foods.length; i++) {
            if(foods[i].equals(food)) {
                index = i;
            }
        }
        return index;
    }
    static void remove(String food) {
        if (indexOf(food) == -1) return;
        String[] temp = new String[foods.length - 1];
        for (int i = indexOf(food); i < foods.length - 1; i++) {
            foods[i] = foods[i + 1];
        }
        for (int i = 0; i < temp.length; i++) {
            temp[i] = foods[i];
        }
        foods = temp;
    }
    static boolean include(String food) {
        return indexOf(food) != -1;
//        boolean found = false;
//        for (int i = 0; i < foods.length; i++) {
//            if(foods[i].equals(food)) {
//                found = true;
//                break;
//            }
//        }
//        return found;
    }
    static void insert(int n, String food) {
        if(n>foods.length) {
            System.out.printf("%d 이하의 숫자를 입력해 주세요.\n", foods.length);
        } else if (n == foods.length) {
            push(food);
        } else {
            String[] temp = new String[foods.length + 1];
            for (int i = 0; i < n; i++) {
                temp[i] = foods[i];
            }
            temp[n] = food;
            for (int i = n + 1; i < temp.length; i++) {
                temp[i] = foods[i - 1];
            }
            foods = temp;
        }
    }
    static void modify(int targetIndex, String food) {
        if(isOutOfBounds(targetIndex)) return; // 안전하게 하려면 걸어야 할 조건
        foods[targetIndex] = food;
    }
    private static boolean isOutOfBounds(int targetIndex) {
        return targetIndex < 0 || targetIndex > foods.length - 1;
    }

    public static void main(String[] args) {

        printFoods();
        push("라면");
        push("김치찌개");
        printFoods();

        int index = indexOf("파스타");
        System.out.println("index = " + index);

        int index2 = indexOf("라면땅");
        System.out.println("index2 = " + index2);

        remove("치킨");
        printFoods();

        boolean flag1 = include("파스타");
        System.out.println("flag1 = " + flag1);

        boolean flag2 = include("떡라면");
        System.out.println("flag2 = " + flag2);

        insert(3, "파인애플");

        printFoods();

        modify(2, "닭갈비");
        printFoods();

    }
}
