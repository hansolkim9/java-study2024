package day02;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayQuiz02 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] nickName = {"영웅재중", "최강창민", "시아준수", "믹키유천", "유노윤호"};

        System.out.println("* 우리반 학생들의 별명: " + Arrays.toString(nickName));
        System.out.println("- 삭제할 학생의 별명을 입력하세요!");

        while (true) {
            String deleteNick = scanner.nextLine();
            boolean found = false;
            if (deleteNick.equals("그만")) {
                break;
            } else {

            for (int i = 0; i < nickName.length; i++) {
                if (nickName[i].equals(deleteNick)) {
                    found = true;
                    System.out.printf("%s의 별명을 삭제합니다.", deleteNick);

                    for (int j = i; j < nickName.length - 1; j++) {
                        nickName[j] = nickName[j + 1];
                    }
                    String[] temp = new String[nickName.length - 1];
                    for (int j = 0; j < temp.length; j++) {
                        temp[j] = nickName[j];
                    }
                    nickName = temp;

                    System.out.printf("* 삭제 후 정보: " + Arrays.toString(nickName) + "\n");
                    break;
                }
            }
            if (!found) {
                System.out.printf("해당 별명(%s)은 존재하지 않습니다\n", deleteNick);
            }
            }
        }
    }
}
