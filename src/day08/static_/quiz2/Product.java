package day08.static_.quiz2;

public class Product extends Store{

    private String productName;
    private int price;

    public Product(String productName, int price) {
        this.productName = productName;
        this.price = price;
    }
    // 제품을 판매하고 Store의 총 판매액을 업데이트
    void sellProduct() {
        Store.addSales(this.price);
    }
}
