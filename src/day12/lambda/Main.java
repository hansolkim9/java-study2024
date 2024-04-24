package day12.lambda;

import java.util.List;

import static day12.lambda.Color.*;
import static day12.lambda.Color.YELLOW;

public class Main {

	public static void main(String[] args) {


		// 사과 바구니 생성
		List<Apple> appleBasket = List.of(
				new Apple(80, GREEN)
				, new Apple(155, GREEN)
				, new Apple(120, RED)
				, new Apple(97, RED)
				, new Apple(200, GREEN)
				, new Apple(50, RED)
				, new Apple(85, YELLOW)
				, new Apple(75, YELLOW)
		);

		List<Apple> greenApples = FilterApple.filterGreenApples(appleBasket);
		System.out.println("greenApples = " + greenApples);

		System.out.println("==========빨강 사과 필터링==========");
		List<Apple> filteredApples1 = FilterApple.filterApplesByColor(appleBasket, RED);
		System.out.println("filteredApples1 = " + filteredApples1);

		System.out.println("==========노랑 사과 필터링==========");
		List<Apple> filteredApples2 = FilterApple.filterApplesByColor(appleBasket, YELLOW);
		System.out.println("filteredApples2 = " + filteredApples2);

	}
}

