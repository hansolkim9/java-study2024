package day10.quiz;

public class MediaPlayer {

	private MediaPlayable[] mediaList = new MediaPlayable[0];

	public void addMedia(MediaPlayable media) {
		// 주어진 media를 mediaList배열에 추가

		MediaPlayable[] newArray = new MediaPlayable[mediaList.length + 1];
		System.arraycopy(mediaList, 0, newArray, 0, mediaList.length);
		newArray[mediaList.length] = media;
		mediaList = newArray;

//		MediaPlayable[] newArray = new MediaPlayable[mediaList.length + 1];
//		for (int i = 0; i < mediaList.length; i++) {
//			newArray[i] = mediaList[i];
//		}
//		newArray[newArray.length - 1] = media;
//		mediaList = newArray;
	}

	public void playAll() {
		// 반복문을 통해 mediaList에 있는 모든 미디어들을 재생시킴
		for (MediaPlayable mediaPlayable : mediaList) {
			mediaPlayable.play();
		}
	}
}
