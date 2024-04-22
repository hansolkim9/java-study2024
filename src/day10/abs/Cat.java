package day10.abs;

public class Cat extends Pet {

	@Override
	public void eat() {
		System.out.println("고양이가 생선을 먹습니다.");
	}
	@Override
	public void sleep() {
		System.out.println("고양이는 낮잠을 많이 잡니다.");
	}
}
