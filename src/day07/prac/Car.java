package day07.prac;

import java.time.LocalDate;

public class Car {

//    **자동차 클래스**
//    - 자동차의 브랜드(brand), 모델(model), 연식(year)을 캡슐화하는 `Car` 클래스를 만드세요.
//    - 모든 필드는 private로 선언하고, 각 필드의 정보를 반환하거나 설정하는 getter와 setter 메소드를 포함하세요.
//    - setter 메소드에서는 유효하지 않은 입력(예: 미래의 연식)을 거부할 수 있도록 검증 로직을 추가하세요.

    private String brand;
    private String model;
    private int year;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        if(brand.isEmpty() || brand == null) {
            System.out.println("유효하지 않은 브랜드명 입니다.");
        } else {
            this.brand = brand;
        }
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if(model.isEmpty() || model == null) {
            System.out.println("유효하지 않은 모델명 입니다.");
        } else {
            this.model = model;
        }
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if(year > LocalDate.now().getYear() || year < 1900) { // 최소 년도 (1900보다 큰) 추가
            System.out.println("유효하지 않은 년도 입니다. " + LocalDate.now().getYear() + "이하의 년도를 입력해주세요.");
        } else {
            this.year = year;
        }
    }
}
