package day10.inter;

// 최신 트랜드는 인터페이스를 쓴다(추상클래스 거의 안씀)
public interface SmartPhone {

	// 인터페이스는 처음 설계부터 객체를 만들지 않을 것을 가정했으므로
	// 생성자 및 필드를 선언할 수 없음. 상수는 선언가능
	int AGE = 10;
	// public static final int AGE = 10;
	// public static final 항상 생략되어있음

	// 인터페이스는 기본적으로 추상화 상태이기 때문에
	// 추상화 키워드를 사용하지 않아도 됨

	// 스펙 보여주기 기능
	void information();

	// 충전 기능
	void charge();

	// 카메라 기능
	void camera();
}
