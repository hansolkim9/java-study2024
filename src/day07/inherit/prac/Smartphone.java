package day07.inherit.prac;

public class Smartphone extends ElectronicProduct{

    int storageCapacity;

    public Smartphone(String productName, int price, String manufacturer, int storageCapacity) {
        this.productName = productName;
        this.price = price;
        this.manufacturer = manufacturer;
        this.storageCapacity = storageCapacity;
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.printf("저장 용량: %d GB", this.storageCapacity);
//        System.out.println("저장 용량 : " + storageCapacity +" GB");
    }
}
