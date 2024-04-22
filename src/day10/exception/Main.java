package day10.exception;

public class Main {

	public static void main(String[] args) {

		ThrowsExample te = new ThrowsExample();

//		int n = te.inputNumber();
//		System.out.println("n = " + n);

//		try {
//			int n = te.convert("550!23");
//			System.out.println("n = " + n);
//		} catch (Exception e) {
//			System.out.println("내입맛에 맞게 예외처리를~");
//		}


		LoginUser user = new LoginUser("abc1234", "1234");

		try {
			user.loginValidate("abc1234", "1234");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace(); // 에러 로그 출력
		}


	}
}
