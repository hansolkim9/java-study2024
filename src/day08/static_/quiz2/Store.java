package day08.static_.quiz2;

public class Store {
    private static int totalSales;

    // 판매액을 총 판매액에 추가하는 메서드
    public static void addSales(int amount) {
        totalSales += amount;
    }

    public static int getTotalSales() {
        return totalSales;
    }
}
