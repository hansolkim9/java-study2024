package day01;

public class DataType {

    public static void main(String[] args) {

        byte a = 127;          // 1byte
        short b = 32767;       // 2byte
        int c = 2147483647;    // 4byte
        long d = 2147483648L;  //8byte
        System.out.println(d);

        float e = 3.1412414F; // 접미사 F써야
        double f = 3.1124124;
        double g = 100; // 정수 가능하지만 100.0(실수)으로 출력
        System.out.println("e = " + e);
        System.out.println("f = " + f);
        System.out.println("g = " + g);

        // 메모리를 극한으로 아껴야하는 상황이 아니라면, 정수는 int, 실수는 double 주로 쓴다!

        boolean flag1 = false;
        boolean flag2 = 10 > 5;

        int i = 100;
        double v = 5.5;
        boolean b1 = true;
        String happy = "happy";

        double random = Math.random();


        int x = 200;
        System.out.println(x + a);
        System.out.println(b * x);

        // 문자형 char : 2byte 할당 0~65536
        char text = 'ㅎ';
        System.out.println("text = " + text);

        // 문자열 : 문자 배열
        char[] hello = {'안', '녕', '하', '세', '요'};
        System.out.println("hello = " + new String(hello));

        String hello2 = "안녕하세요";
    }
}
