package day07.prac;

public class PasswordManager {
//    **비밀번호 관리 클래스**
//    - 사용자의 비밀번호를 관리하는 `PasswordManager` 클래스를 작성하세요.
//    - 비밀번호(password) 필드는 private으로 선언하고, 비밀번호를 설정하고 변경할 수 있는 메소드를 public으로 만드세요.
//    - 비밀번호 변경 시 현재 비밀번호를 입력받아야만 변경 가능하도록 구현하세요.

    private String password;

    // 생성자
    PasswordManager(String password) {
        this.password = password;
    }

    /**
     * 비밀번호 변경해주는 메서드
     * @param oldPassword - 기존에 사용하던 비밀번호
     * @param newPassword - 새로 변경할 비밀번호
     * @return - 비밀번호 변경 성공 시 true, 실패 시 false
     */
    public boolean changePassword(String oldPassword, String newPassword) {
        if (oldPassword.equals(this.password)) {
            this.password = newPassword;
            return true;
        } else {
            System.out.println("비밀번호가 틀렸습니다.");
            return false;
        }
    }
}
