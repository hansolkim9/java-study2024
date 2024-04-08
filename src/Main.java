//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

        System.out.println(123);
        System.out.println("문자열 무조건 쌍따옴표");

        int month = 5;
        int day = 5;
        String anni = "어린이날";

        /*
        System.out.println(month + "월 " + day + "일은 " + anni + "입니다.");
        System.out.printf("%d월 %d일은 %s입니다.\n", month, day, anni);
         */
        System.out.printf("%d월 %d일은 %s입니다.\n", month, day, anni);

        int x = 10, y = 20;

        // & 하나만 쓰면 단축평가를 수행하지 않아 y/0을 실행해서 에러가 난다.
        System.out.println(x > 10 && (y / 0 == 10)); //false
        System.out.println(x > 10 || y < 30); //true
    }
}