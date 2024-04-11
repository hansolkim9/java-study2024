package day04;

public class DancerMain {

    // 실행용 클래스: 객체를 생성해서 객체의 기능을 실행시키는 곳
    // -> main이 필요
    public static void main(String[] args) {

        // 설계도(클래스)를 통해 객체를 찍어냄(생성)
        Dancer kim = new Dancer();

        // 객체의 속성 부여
        kim.dancerName = "김춘식";
        kim.crewName = "K";
        kim.genre = "a";
        kim.danceLevel = 1;

        kim.introduce();
        kim.dance();

        // 두 번째 댄서
        Dancer park = new Dancer();

        park.dancerName = "박영식";
        park.crewName = "P";
        park.genre = "b";
        park.danceLevel = 2;

        park.dance();

        Dancer hong = new Dancer(); // 생성자 호출: 객체 생성시 1회 호출
        hong.dance();

        Dancer choi = new Dancer("최최");
        choi.dance();
        choi.introduce();

        Dancer hhh = new Dancer("김ㅎㅎ", "H");
        hhh.dance();
        hhh.introduce();

        Dancer rock = new Dancer("메롱롱", "폭식맨", "락킹");
        rock.introduce();

    }
}
