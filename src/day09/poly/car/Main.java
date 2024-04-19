package day09.poly.car;

import day04.Dancer;

public class Main {

    public static void main(String[] args) {

        Car sonata1 = new Sonata();
        Car sonata2 = new Sonata();
        Sonata sonata3 = new Sonata();

        Car tuscon1 = new Tucson();
        Car tuscon2 = new Tucson();

        Car mustang1 = new Mustang();
        Car mustang2 = new Mustang();
        Car mustang3 = new Mustang();
        Car mustang4 = new Mustang();

        // 다형성을 통해 이종모음 배열을 구현할 수 있
        Car[] cArr = {sonata1, tuscon1, mustang1, mustang2};
        for (Car car : cArr) {
            car.accelerate();
        }

        Object[] sArr = {"abc", 100, false, new Tucson()};

        System.out.println("=======================");

        Driver driver = new Driver();
        driver.drive(new Mustang());

    }
}
