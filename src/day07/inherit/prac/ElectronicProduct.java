package day07.inherit.prac;

public class ElectronicProduct {

    String productName;
    double price;
    String manufacturer;

    public void displayInfo() {
        System.out.printf("%s, 가격: %.0f원, 제조사: %s\n", this.productName, this.price, this.manufacturer);
//        System.out.println(productName + "Price: " + price + ", 제조사: " + manufacturer);
    }

}
