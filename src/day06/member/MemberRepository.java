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

    // 회원정보 생성
    void addNewMember(Member newMember) {

        // 배열에 데이터를 추가하는 로직
        Member[] temp = new Member[members.length + 1];
        for (int i = 0; i < members.length; i++) {
            temp[i] = members[i];
        }
        temp[temp.length - 1] = newMember;
        members = temp;
    }
}
