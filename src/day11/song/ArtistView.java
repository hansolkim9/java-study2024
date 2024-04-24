package day11.song;

import java.util.Set;

import static util.SimpleInput.input;

// 프로그램 입출력 처리 담당
public class ArtistView {

	private static ArtistRepository repository = new ArtistRepository();

	// 프로그램 실행
	public static void start() {
		while (true) {
			switch (showMusicManagementProgramMenu()) {
				case "1":
					registMusic();
					break;
				case "2":
					searchMusic();
					break;
				case "3":
					boolean flag = exitProgram();
					if (flag) return;
					break;
				default:
					System.out.println("# 메뉴를 잘못 선택했습니다.");
			}
		}
	}

	// 프로그램 메뉴 화면 출력
	public static String showMusicManagementProgramMenu() {
		System.out.println("\n****** 음악 관리 프로그램 ******");
		System.out.printf("# 현재 등록된 가수: %d명\n", repository.count());
		System.out.println("# 1. 노래 등록하기");
		System.out.println("# 2. 노래 정보 검색");
		System.out.println("# 3. 프로그램 종료");
		System.out.println("====================");
		String menuNumber = input(">>");
		return menuNumber;
	}

	// 1. 노래 등록 입출력정보
	public static void registMusic() {
		System.out.println("\n 노래 등록을 시작합니다.");
		String artistName = input("- 가수명: ");
		String songName = input("- 노래명: ");

		// 결과 화면 출력
		if (!repository.isRegistered(artistName)) { // 신규 등록
			repository.addNewArtist(artistName, songName);
			System.out.printf("# %s님이 신규 등록 되었습니다.", artistName);
			repository.save();
		} else { // 신규 등록 아니라 기존 가수에 곡명만 추가
			// 새로운 노래를 추가해 본다. 추가가 잘 되었는지 여부를 확인한다.
			boolean flag = repository.addNewSong(artistName, songName);
			if (flag) { // 기존 가수의 트랙리스트에 노래만 추가하는 경우
				System.out.printf("\n# %s님의 노래목록에 %s곡이 추가되었습니다.\n", artistName, songName);

			} else { // 노래 중복된 경우
				System.out.printf("\n# [%s]곡은 이미 등록된 노래입니다.\n", songName);
			}
		}
	}

	// 2. 노래 검색 입출력정보
	public static void searchMusic() {
		System.out.println("\n# 검색할 가수명을 입력하세요.");
		String artistName = input("- 가수명: ");

		if (repository.isRegistered(artistName)) { // 검색한 가수가 저장되어 있는 경우
			// 노래목록 가져와 출력
			int num = 1;
			Set<String> songList =  repository.getSongList(artistName);
			System.out.printf("\n# %s님의 노래목록 \n", artistName);
			System.out.println("====================");
			for (String song : songList) {
				System.out.printf("# %d. %s\n", num++, song);
			}
		} else { // 없는 가수라면
			System.out.println("\n# 해당 가수는 등록되지 않았습니다.");
		}
	}

	// 프로그램 종료 판단 입출력
	static boolean exitProgram() {
		while (true) {
			String exit = input("- 프로그램을 종료까요?? [Y/N]").toUpperCase();
			if (exit.equals("Y")) {
				System.out.println("프로그램을 종료합니다.");
				return true;
			} else if (exit.equals("N")) {
				System.out.println("프로그램 종료를 취소합니다.");
				return false;
			} else {
				System.out.println("잘못 입력하셨습니다.");
			}
		}
	}
}
