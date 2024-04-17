package day07.player;

import java.util.Scanner;

// 상위 클래스 (super class)
// : 공통 속성(과 기능을 가진 부모 클래스
public class Player {

    Scanner sc = new Scanner(System.in);

    String nickName;
    int level;
    int hp;

    // 현재 캐릭터 정보를 출력
    public void showStatus() {
        System.out.println("\n========== Character's Info ==========");
        System.out.println("# name: " + this.nickName);
        System.out.println("# level: " + this.level);
        System.out.println("# hp: " + this.hp);
    }

}
