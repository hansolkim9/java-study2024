package day10.quiz;

public class ImageDisplay implements MediaPlayable {
	@Override
	public void play() {
		System.out.println("이미지가 재생됩니다.");
	}

	@Override
	public void pause() {
		System.out.println("이미지가 일시정지 됩니다.");
	}

	@Override
	public void stop() {
		System.out.println("이미지 재생을 종료합니다.");
	}
}
