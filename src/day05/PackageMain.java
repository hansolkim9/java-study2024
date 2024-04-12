package day05;

// 다른 패키지에 있는 클래스를 로딩할 때 이름을 축약해서 쓰기위해 사용
//import day05.juice.Apple;
//import day05.juice.Banana;
//import day05.juice.Peach;
import day05.juice.*;

import java.util.Scanner;

public class PackageMain {

    public static void main(String[] args) {

        // 2 개의 다른 애플을 불러올 때는 import로는 해결이 안되는듯 하다
        day05.fruit.Apple a1 = new day05.fruit.Apple();
        day05.juice.Apple a2 = new day05.juice.Apple();

        new Banana();
        new Peach();

        Scanner sc = new Scanner(System.in);
    }
}
