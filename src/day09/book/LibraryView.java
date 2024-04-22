package day09.book;

import static util.SimpleInput.input;

// 역할: 도서관리 프로그램에서 입출력을 담당하는 객체
public class LibraryView {

    private static LibraryRepository repository;

    static {
        repository = new LibraryRepository();
    }

    // 회원 정보를 입력받는 기능
	static void inputUserInfo() {
        System.out.println("\n# 회원 정보를 입력해 주세요.");
        String name = input("# 이름: ");
        int age = Integer.parseInt(input("# 나이: "));
        Gender gender = inputGender();

        // 입력된 데이터를 저장
        repository.saveBookUser(new BookUser(name, age, gender, 0));
    }

    // 성별을 정확히 입력할때까지 무한히 입력받고
    // 정확히 입력하면 해당 성별 문자를 리턴
    private static Gender inputGender() {
        while (true) {
            String gender = input("# 성별(M/F): ").toUpperCase();
            if (gender.startsWith("M")) return Gender.MALE;
            if (gender.startsWith("F")) return Gender.FEMALE;
            System.out.println("\n# 성별을 잘못 입력했습니다.");
        }
    }

    // 메뉴 화면 출력
    static String showLibraryMenu() {
        System.out.println("\n========== 도서 메뉴 ==========");
        System.out.println("# 1. 마이페이지");
        System.out.println("# 2. 도서 전체 조회");
        System.out.println("# 3. 도서 제목으로 검색");
        System.out.println("# 4. 도서 대여하기");
        System.out.println("# 5. 도서 저자이름으로 검색");
        System.out.println("# 9. 프로그램 종료하기");

        String menuNumber = input("- 메뉴 번호:");
        return menuNumber;
    }

    // 회원 정보를 출력
    public static void displayUserInfo() {
        System.out.println("\n********** 회원님 정보 **********");
        System.out.println("# 회원명: " + LibraryRepository.getUser().getName());
        System.out.println("# 나이: " + LibraryRepository.getUser().getAge());
        System.out.println("# 성별: " + LibraryRepository.getUser().getGender());
        System.out.println("# 쿠폰개수: " + LibraryRepository.getUser().getCouponCount());
    }

    // 전체 도서 정보를 출력
    private static void displayAllBooks() {
        System.out.println("========== 전체 도서 목록 ==========");
        Book[] informationList = repository.getAllBooksInfo();

        for (Book book : informationList) {
            System.out.println(book.info());
        }
    }

    // 3. 책 제목으로 검색어 포함된 책 내용 출력하기
    private static void searchBooksByTitle() {
        String keyword = input("# 검색어: ");

        Book[] searchBooks = repository.searchBookList(keyword);

        if (searchBooks.length > 0) {
            System.out.printf("\n======== [%s] 검색 결과 =========\n", keyword);
            for (Book searchBook : searchBooks) {
                System.out.println(searchBook.info());
            }
        } else {
            System.out.println("\n# 검색 결과가 없습니다.");
        }
    }

    // 4. 도서 대여
    private static void rentBook() {
        displayAllBooks();
        String bookNum = input("- 대여할 도서 번호 입력: ");
        // 저장소에다가 대여가능한지 여부 검증
        RentStatus status = repository.rentBook(Integer.parseInt(bookNum));

        if (status == RentStatus.RENT_SUCCESS_WITH_COUPON) {
            System.out.println("# 성공적으로 요리책이 쿠폰발급과 함께 대여되었습니다.");
        } else if (status == RentStatus.RENT_SUCCESS) {
            System.out.println("# 도서가 성공적으로 대여되었습니다.");
        } else {
            System.out.println("# 도서 대여에 실패했습니다.");
        }
    }

    // 프로그램 종료 판단 입출력
	static boolean exitProgram() {
        while (true) {
            String exit = input("- 프로그램을 종료까요?? [Y/N]").toLowerCase();
            if (exit.equals("y")) {
                System.out.println("프로그램을 종료합니다.");
                return true;
            } else if (exit.equals("n")) {
                System.out.println("프로그램 종료를 취소합니다.");
                return false;
            } else {
                System.out.println("잘못 입력하셨습니다.");
            }
        }
    }


    // 코드 흐름 캡슐
    static void start() {
        inputUserInfo();


        while(true) {

            switch (showLibraryMenu()) {
                case "1":
                    displayUserInfo();
                    break;
                case "2":
                    displayAllBooks();
                    break;
                case "3":
                    searchBooksByTitle();
                    break;
                case "4":
                    rentBook();
                    break;
                case "5":
                    break;
                case "9":
                    boolean flag = exitProgram();
                    if (flag) return;
                    break;
                default:
                    System.out.println("올바른 번호를 입력해주세요");
            }
        }
    }


}
