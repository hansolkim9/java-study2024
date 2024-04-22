package day10.quiz;

public class Main {

	public static void main(String[] args) {

		MediaPlayer player = new MediaPlayer();
		player.addMedia(new VideoPlayer());
		player.addMedia(new AudioPlayer());
		player.addMedia(new ImageDisplay());

		player.playAll();  // 모든 미디어 파일 재생 (각각의 play메서드 호출)
	}
}

/*
예시 출력

비디오가 재생됩니다.
오디오가 재생됩니다.
이미지가 재생됩니다.
*/
