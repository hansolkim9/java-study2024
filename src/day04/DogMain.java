package day04;

public class DogMain {

    int x = 20; // 필드
    public static void main(String[] args) {

        int a = 10; // 지역변수
        Dog sik = new Dog("춘식");
        Dog bae = new Dog("춘배");

        System.out.println("bae = " + bae);
        System.out.println("sik = " + sik);

        sik.petInfo();
        System.out.println("====================");
        bae.inject();
        bae.petInfo();
    }
}
