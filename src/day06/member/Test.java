package day06.member;

public class Test {

    public static void main(String[] args) {

        Member[] arr = new Member[5];

        // 괄호 안이 비어있다 > 기본생성자(default)
        Member m1 = new Member("hs@kim.com", "1234", "김영식", "남성", 10);
        Member m2 = new Member("adf@sdlf.com", "3456", "김춘배", "여성", 9);

        arr[0] = m1;
        arr[1] = m2;
        arr[2] = new Member("ad","c","C","f",10);

        System.out.println("m1 = " + m1); //.toString() 자동으로 생성된다.
        System.out.println("m2 = " + m2);

        Member[] members = {m1, m2};
    }
}
