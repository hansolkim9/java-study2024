package day10.inter.animal;

// 인터페이스로 다중 상속이 안되는 문제를 해결
public class BullDog extends Animal implements Pet, Aggressive {

	@Override
	public void handle() {

	}

	@Override
	public boolean inject() {
		return false;
	}

	@Override
	public void hunt(Pet pet) {

	}

	@Override
	public void violent() {

	}

	// 사냥 기능

	// 난폭함

	// 애완동물 가능
}
