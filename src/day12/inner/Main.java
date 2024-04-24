package day12.inner;

public class Main {

	// 내부 클래스 (중첩 클래스)
	// 뺄셈 계산기 필요, main 클래스 안에서만 사용 (외부에서 사용 X)
	private static class SubCalculator implements Calculator {

		@Override
		public int operate(int n1, int n2) {
			return n1 - n2;
		}
	}

	public static void main(String[] args) {

		Calculator cal;
		cal = new AddCalculator();

		int r1 = cal.operate(10, 20);
		System.out.println("r1 = " + r1);

		cal = new SubCalculator();
		int r2 = cal.operate(55, 14);
		System.out.println("r2 = " + r2);

		// 익명 클래스: 이름이 없는 클래스를 빠르게 선언하는 법
		// 클래스를 통해 객체를 생성하긴 하지만 재활용은 안할 것이라면
		cal = new Calculator() {
			@Override
			public int operate(int n1, int n2) {
				return n1 * n2;
			}
		};

		int r3 = cal.operate(10, 4);
		System.out.println("r3 = " + r3);

		// 람다
		// 사용 전제조건
		// - 반드시 인터페이스 안의 추상메서드가 1개여야 한다.
		cal = (n1, n2) -> n1 / n2;

		int r4 = cal.operate(20, 5);
		System.out.println("r4 = " + r4);

		System.out.println("=========================");

		Restaurant fr = new FrenchRestaurant();
		Restaurant fr2 = new FrenchRestaurant();
		Restaurant fr3 = new FrenchRestaurant();

		Restaurant japaneseRestaurant = new Restaurant() {

			@Override
			public void cook() {
				System.out.println("일식 요리를 합니다.");
			}
		};

		Restaurant italian = () -> System.out.println("이탈리아 요리를 합니다.");

	}
}