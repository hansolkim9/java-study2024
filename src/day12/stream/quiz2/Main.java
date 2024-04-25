package day12.stream.quiz2;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;

import static java.util.stream.Collectors.*;

public class Main {

	public static void main(String[] args) {

		Destination paris = new Destination("Paris", "France");
		Destination rome = new Destination("Rome", "Italy");
		Destination berlin = new Destination("Berlin", "Germany");

		Traveler alice = new Traveler("Alice", "alice@example.com");
		Traveler bob = new Traveler("Bob", "bob@example.com");
		Traveler charlie = new Traveler("Charlie", "charlie@example.com");

		List<Booking> bookings = List.of(
				new Booking(alice, paris, 2022, 2000),
				new Booking(bob, rome, 2021, 1500),
				new Booking(alice, berlin, 2023, 1800),
				new Booking(charlie, paris, 2022, 2200),
				new Booking(bob, paris, 2021, 2500)
		);

		System.out.println("\n========== 연습1 ==========\n");
		// 연습 1: 2022년에 예약된 모든 여행을 찾아 가격 오름차 정렬.
		bookings.stream()
				.filter(b -> b.getYear() == 2022)
				.sorted(Comparator.comparing((Booking b) -> b.getPrice()))
				.collect(toList())
				.forEach(System.out::println);

		System.out.println("\n========== 연습2 ==========\n");
		// 연습 2: 여행지가 있는 모든 나라 이름을 중복 없이 나열하시오.
		bookings.stream()
				.map(t -> t.getDestination().getCountry())
				.collect(toSet())
				.forEach(System.out::println);

		System.out.println("\n========== 연습3 ==========\n");
		// 연습 3: Paris에 예약된 모든 여행자를 찾아 이름순으로 오름차 정렬.
		bookings.stream()
				.filter(b -> b.getDestination().getCity().equals("Paris"))
				.map(b -> b.getTraveler().getName())
				.sorted(Comparator.comparing((String b) -> b))
				.collect(toList())
				.forEach(System.out::println);

		System.out.println("\n========== 연습4 ==========\n");
		// 연습 4: 모든 여행자의 이메일을 리스트에 모아서 알파벳순으로 오름차정렬하여 반환.
		List<String> emailList = bookings.stream()
				.map(b -> b.getTraveler().getEmail())
				.sorted(Comparator.comparing((String b) -> b))
				.collect(toList());
		System.out.println("이메일 리스트 = " + emailList);

		System.out.println("\n========== 연습5 ==========\n");
		// 연습 5: Italy로의 여행이 한 건이라도 있는지 여부 확인.
		boolean flag1 = bookings.stream()
				.anyMatch(b -> b.getDestination().getCountry().equals("Italy"));
		System.out.println("Italy로의 여행이 한건이라도 있는지 = " + flag1);

		System.out.println("\n========== 연습6 ==========\n");
		// 연습 6: France로의 모든 여행의 총 가격을 출력.
		double priceTotalFrance = bookings.stream()
				.filter(b -> b.getDestination().getCountry().equals("France"))
				.mapToDouble(b -> (int) b.getPrice())
				.sum();
		System.out.println("France로의 모든 여행의 총 가격 = " + priceTotalFrance);

		System.out.println("\n========== 연습7 ==========\n");
		// 연습 7: 예약된 모든 여행에서 최고 가격은 얼마인가?
		double maxPrice = bookings.stream()
				.mapToDouble(b -> b.getPrice())
				.max()
				.getAsDouble();
		System.out.println("최고 가격 = " + maxPrice);


		System.out.println("\n========== 연습8 ==========\n");
		// 연습 8: 가장 저렴한 여행의 정보 탐색.
		Booking minPrice = bookings.stream()
				.min(Comparator.comparing(Booking::getPrice))
				.orElse(null);
		System.out.println("가장 저렴한 여행의 정보 = " + minPrice);


		System.out.println("\n========== 연습9 ==========\n");
		// 연습 9: 가격이 2000 이상인 모든 여행 예약 정보를 출력.
		bookings.stream()
				.filter(b -> b.getPrice() > 2000)
				.collect(toList())
				.forEach(System.out::println);

		System.out.println("\n========== 연습10 ==========\n");
		// 연습 10: 모든 예약에서 가장 낮은 가격보다 높은 가격을 가진 예약의 평균 가격을 계산하시오.
		double average = bookings.stream()
				.mapToInt(b -> (int) b.getPrice())
				.filter(b -> b > minPrice.getPrice())
				.average()
				.getAsDouble();
		System.out.println("average = " + average);

		System.out.println("\n========== 연습11 ==========\n");
		// 연습 11: 모든 여행자의 여행 예약을 여행지별로 그룹화하여 출력하시오.
		Map<Destination, List<Booking>> bookingsByDestination = bookings.stream()
				.collect(groupingBy(Booking::getDestination));
		System.out.println("bookingsByDestination = " + bookingsByDestination);;

		System.out.println("\n========== 연습12 ==========\n");
		// 연습 12: 모든 예약 중 최고 가격과 최저 가격의 차이를 계산하시오.
		System.out.println(maxPrice - minPrice.getPrice());
	}

}
