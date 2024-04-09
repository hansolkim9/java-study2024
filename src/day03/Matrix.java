package day03;

import java.sql.SQLOutput;
import java.util.Arrays;

public class Matrix {

    public static void main(String[] args) {

        int korScore = 77;
        int engScore = 100;
        int mathScore = 99;

        int[] scoresKim = {korScore, engScore, mathScore};
        int[] scoresPark = {100, 22, 56};
        int[] scoresHong = {40, 90, 80};

        // 2차원 배열: 배열 안의 요소가 배열인 형태
        int[][] classScore = { scoresKim, scoresPark, scoresHong };
        /*
            {
                {77, 100, 99},
                {100, 22, 56},
                {40, 90, 80}
            }
        */
        System.out.println(classScore.length); // 배열의 길이 : 3 출력
        System.out.println(classScore[0] == scoresKim); // classScore의 0번 index : true 출력
        System.out.println(Arrays.toString(classScore[1])); // classScore의 1번 index : [100, 22, 56] 출력
        System.out.println(classScore[2][1]); // classScore의 2번 index[40, 90, 80] 의 1번 index 90 출력

        System.out.println(Arrays.toString(classScore)); // 배열 주소 출력
        System.out.println(Arrays.deepToString(classScore)); // 배열 그대로 출력

        System.out.println("==================================");

        System.out.println("2차원 배열의 2번 인덱스 주소: " + classScore[2]);
        System.out.println("scoresHong의 주소: " + scoresHong);

        System.out.println("==================================");

        // 2차원 배열의 순회
        for (int i = 0; i < classScore.length; i++) {
            for (int j = 0; j < classScore[i].length; j++) {
                System.out.printf("%d ", classScore[i][j]);
            }
            System.out.println();
        }

        // js : for ~ of, java : enhanced for loop, iteration, foreach
        System.out.println("==================================");

        for (int[] scores : classScore) {
            for (int n : scores) {
                System.out.printf("%d ", n);
            }
            System.out.println();
        }

        System.out.println("==================================");

        int[][] arr2by3 = {
                {10, 20, 30},
                {40, 50, 60}
        };

        // 빈배열 생성(기본값 0 삽입)
        int[][] arr4by5 = new int[4][5];
        for (int[] ints : arr4by5) {
            for (int anInt : ints) {
                System.out.printf("%d", anInt);
            }
            System.out.println();
        }
    }
}
