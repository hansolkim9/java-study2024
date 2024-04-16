package day06.member;

// 역할: 회원 배열을 관리하는 역할 (입출력 X) - 데이터 저장소
public class MemberRepository {

    // 필드
    static Member[] members;

    // 생성자
    MemberRepository() {
        this.members = new Member[3];
        members[0] = new Member("abc@def.com", "23", "김영식", "남성", 10);
        members[1] = new Member("aec@def.com", "13", "김춘배", "남성", 11);
        members[2] = new Member("cwt@def.com", "12", "김팔봉", "남성", 12);
    }

    // 메서드

    /**
     * 생성된 회원정보를 회원 배열 끝에 추가하는 기능
     * @param newMember - 사용자의 입력으로 전달된 회원 정보 객체
     */
    void addNewMember(Member newMember) {

        // 이메일이 중복인가?

        // 배열에 데이터를 추가하는 로직
        Member[] temp = new Member[members.length + 1];
        for (int i = 0; i < members.length; i++) {
            temp[i] = members[i];
        }
        temp[temp.length - 1] = newMember;
        members = temp;
    }

    /**
     * 이메일 중복을 확인하는 기능
     * @param targetEmail - 검사할 사용자의 입력 이메일값
     * @return - 이메일이 이미 존재한다면 true, 존재하지 않는 사용가능한 이메일이면 false
     * @author - 김코딩
     * @sinces 2024.04.16.
     */
    boolean isDuplicateEmail(String targetEmail) {
        for (Member m : members) {
            if (targetEmail.equals(m.email)) {
                return true;
            }
        }
        return false;
    }
}
