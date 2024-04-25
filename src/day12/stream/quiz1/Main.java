package day12.stream.quiz1;

import java.util.*;

import static java.util.stream.Collectors.*;

public class Main {

	public static void main(String[] args) {

		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");

		List<Transaction> transactions = List.of(
				new Transaction(brian, 2021, 300),
				new Transaction(raoul, 2022, 1000),
				new Transaction(raoul, 2021, 400),
				new Transaction(mario, 2021, 710),
				new Transaction(mario, 2022, 700),
				new Transaction(alan, 2022, 950)
		);

		System.out.println("\n========== 연습1 ==========\n");
		// 연습 1: 2021년에 발생한 모든 거래를 찾아 거래액 오름차 정렬(작은 값에서 큰 값).
		// List<Transaction>
		transactions.stream()
				.sorted(Comparator.comparing((Transaction t) -> t.getValue()))
				.collect(toList())
				.forEach(System.out::println);


		System.out.println("\n========== 연습2 ==========\n");
		// 연습 2: 거래자가 근무하는 모든 도시이름을 중복 없이 나열하시오.
		// List<String>
		transactions.stream()
				.map(t -> t.getTrader().getCity())
				.collect(toSet())
				.forEach(System.out::println);



		System.out.println("\n========== 연습3 ==========\n");
		// 연습 3: Cambridge에 근무하는 모든 거래자를 찾아 거래자리스트로 이름순으로 오름차정렬.
		// List<Trader>
		transactions.stream()
				.map(Transaction::getTrader)
				.filter(t -> t.getCity().equals("Cambridge"))
				.sorted(Comparator.comparing(Trader::getName))
				.forEach(System.out::println);


		System.out.println("\n========== 연습4 ==========\n");
		// 연습 4: 모든 거래자의 이름을 리스트에 모아서 알파벳순으로  오름차정렬하여 반환
		// List<String>
		List<String> traderName = transactions.stream()
				.map(t -> t.getTrader().getName())
				.distinct()
				.sorted()
				.collect(toList());
		System.out.println("거래자 목록 = " + traderName);


		System.out.println("\n========== 연습5 ==========\n");
		// 연습 5: Milan에 거주하는 거래자가 한명이라도 있는지 여부 확인?
		boolean flag1 = transactions.stream()
				.anyMatch(t -> t.getTrader().getCity().equals("Milan"));
		System.out.println("Milan에 거주하는 거래자가 있는지 = " + flag1);


		System.out.println("\n========== 연습6 ==========\n");
		// 연습 6: Cambridge에 사는 거래자의 모든 거래액의 총합 출력.
		int totalValueByCambridge = transactions.stream()
				.filter(t -> t.getTrader().getCity().equals("Cambridge"))
				.mapToInt(Transaction::getValue)
				.sum();
		System.out.println("Cambridge에 사는 거래자의 모든 거래액의 총 합 = " + totalValueByCambridge);


		System.out.println("\n========== 연습7 ==========\n");
		// 연습 7: 모든 거래에서 최고거래액은 얼마인가?
		int maxTradeValue = transactions.stream()
				.mapToInt(Transaction::getValue)
				.max()
				.getAsInt();
		System.out.println("최고거래액 = " + maxTradeValue);
//				.sorted(Comparator.comparing((Integer t) -> t).reversed())
//				.limit(1)
//				.collect(Collectors.toList());
//		System.out.println("maxTradeValue = " + maxTradeValue);

		/*
		자바의 단점: 널 체크 문법이 없음
		 */

		System.out.println("\n========== 연습8 ==========\n");
		// 연습 8. 가장 작은 거래액을 가진 거래정보 탐색
//		List<Transaction> minTrade = transactions.stream()
//				.sorted(Comparator.comparing((Transaction t) -> t.getValue()))
//				.limit(1)
//				.collect(Collectors.toList());
//		System.out.println("minTrade = " + minTrade);
		Transaction minTrade = transactions.stream()
				.min(Comparator.comparing(Transaction::getValue))
				.orElse(null); // 만약 결과가 null일 경우 어떻게 할 것인지!
		System.out.println("최소 거래액을 가진 거래정보 = " + minTrade);


		System.out.println("\n========== 연습9 ==========\n");
		// 연습 9. 거래액이 500 이상인 거래들만 필터링하고, 해당 거래의 정보를 출력하시오.
		transactions.stream()
				.filter(t -> t.getValue() >= 500)
				.collect(toList())
				.forEach(System.out::println);


		System.out.println("\n========== 연습10 ==========\n");
		// 연습 10. 모든 거래에서 가장 작은 거래액보다 큰 거래액을 가진 거래의 평균을 계산하시오.
		double average = transactions.stream()
				.mapToInt(Transaction::getValue)
				.filter(v -> v > minTrade.getValue())
				.average()
				.getAsDouble();
		System.out.println("average = " + average);

		// 출력값: 752.0


		System.out.println("\n========== 연습11 ==========\n");
		// 연습 11. "Cambridge"에서 거래하는 모든 거래자의 거래액을 연도별로 그룹화하여 출력하시오.
		Map<Integer, List<Transaction>> cambridge = transactions.stream()
				.filter(t -> t.getTrader().getCity().equals("Cambridge"))
				.collect(groupingBy(Transaction::getYear));
		System.out.println(cambridge);

        /*
               출력예시

                Year: 2021
                {Trader: Brian in Cambridge, year: 2021, value: 300}
                {Trader: Raoul in Cambridge, year: 2021, value: 400}

                Year: 2022
                {Trader: Raoul in Cambridge, year: 2022, value: 1000}
                {Trader: Alan in Cambridge, year: 2022, value: 950}
         */



		System.out.println("\n========== 연습12 ==========\n");
		// 연습 12. 모든 거래 중 가장 큰 거래액과 가장 작은 거래액의 차이를 계산하시오.
		System.out.println(maxTradeValue - minTrade.getValue());
		// 출력 값 : 700

	}

}
