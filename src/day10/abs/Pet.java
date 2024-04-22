package day10.abs;

// 추상 메서드 - 자식에게 이름만 제공
public abstract class Pet {

	String name;
	int age;
	String kind;

	Pet() {

	}

	// 선택기능은 객체가 필요에 따라 오버라이딩 하는 것이지 모두에게 강요할 필요가 없다면 굳이 추상화 하지 않아도 됨
	public void walk() {
		System.out.println("산책은 공원");
	}

	// 필수기능은 없으면 객체가 불안정해지므로 강요할 필요가 있으므로 추상화
	public abstract void eat();

	// 추상 메서드는 본문이 없는 껍데기 역할( 자식들에게 기능 이름을 통일시키기 위한 장치 )로만 사용
	// 추상 메서드는 추상 클래스 안에서만 선언 가능
	// 다만 추상 클래스 내부에는 추상 메서드 이외에 모든 메서드 선언 가나ㅡㅇ
	public abstract void sleep();

}
