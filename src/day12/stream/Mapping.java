package day12.stream;

import java.util.List;
import java.util.stream.Collectors;

import static day12.stream.Menu.*;

// map : 리스트에서 원하는 데이터만 추출
// original : [ {}, {}, {}, {}, {} ]
// filter   : [ {}, {}, {} ]
// map      : [ "", "", "", "", "" ]

public class Mapping {

	public static void main(String[] args) {

		// 요리 이름만 추출
		List<String> nameList = menuList
				.stream()
				.map(dish -> dish.getName())
				.collect((Collectors.toList()));
		System.out.println(nameList);

		List<String> words = List.of(
				"safari", "chrome", "ms edge", "opera", "firefox"
		);

		List<Integer> collected = words.stream()
				.map(w -> w.length())
				.collect(Collectors.toList());
		System.out.println(collected);

		List<Character> characterList = words.stream()
				.map(w -> w.charAt(0)) // charAt(index): 문자열에서 해당위치 글자 추출
				.collect(Collectors.toList());
		System.out.println(characterList);

		System.out.println("=======================");


		// 메뉴 목록에서 메뉴이름과 칼로리를 추출해서
		// 새로운 객체에 포장하고 싶다면
		List<SimpleDish> simpleDishLish = menuList.stream()
				.map(SimpleDish::new)
				.collect(Collectors.toList());

		simpleDishLish.forEach(System.out::println);

		/*
            메뉴 목록에서 칼로리가 500칼로리보다 큰
            음식들을 필터링한 다음에 음식의 이름과 타입만
            추출해서 출력해주세요.

            단, 타입은 MEAT의 경우 육류 라고 저장
            FISH는 어류 라고 저장, OTHER는 기타 라고 저장
         */

		List<DishDetail> dishDetailList = menuList.stream()
				.filter(d -> d.getCalories() > 500)
				.map(d -> new DishDetail(d))
				.collect(Collectors.toList());

		System.out.println(dishDetailList);

		System.out.println("=======================");

		// 메뉴 목록에 있는 요리들의 총 칼로리 수 구하기
		int sum = menuList.stream()
				.mapToInt(d -> d.getCalories())
				.sum();
		System.out.println("sum = " + sum);
		
		// 육류 메뉴의 평균 칼로리
		double average = menuList.stream()
				.filter(d -> d.getType() == Dish.Type.MEAT)
				.mapToInt(d -> d.getCalories())
				.average()
				.getAsDouble();
		System.out.println("average = " + average);

	}
}
