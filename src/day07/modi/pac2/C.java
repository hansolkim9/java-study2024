package day07.modi.pac2;

import day07.modi.pac1.A;
//import day07.modi.pac1.B;

// A, B 와 다른 패키지!
public class C {

    public int y1;
    int y2; // default
    private int y3;

    void test() {

        A a = new A(100);// public, 패키지가 다르기 때문에 import는 해줘야 한다.
//        new A(3.14); // dafault
//        new A(false); // private

        a.f1 = 10; // public
//        a.f2 = 20; // default
//        a.f3 = 30; // private

        a.m1();
//        a.m2();
//        a.m3();

//        new B();

    }
}
