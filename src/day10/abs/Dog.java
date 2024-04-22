package day10.abs;

public class Dog extends Pet {

	@Override
	public void eat() {
		System.out.println("강아지가 사료를 먹습니다.");
	}
	@Override
	public void sleep() {
		System.out.println("강아지가 마당에서 낮잠을 잡니다.");
	}
}
