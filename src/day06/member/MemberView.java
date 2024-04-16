package day06.member;

import util.SimpleInput;

// 역할: 회원 데이터 관리를 위해 입력 출력을 담당함
public class MemberView {

    // 객체의 협력
    MemberRepository mr;
    SimpleInput si;

    MemberView() {
        this.mr = new MemberRepository();
        this.si = new SimpleInput();
    }

    void showMembers() {
        System.out.printf("========== 현재 회원 목록 (총 %d명) ==========\n", mr.members.length);
        for (Member m : mr.members) {
            System.out.println(m);
        }
    }

    // 회원정보 생성을 위해 입력을 처리
    void inputNewMember() {
        if(mr.members.length >= 10) return;

        System.out.println();
        System.out.println("# 회원 등록을 시작합니다!!");
        String email = null;
        while (true) {
            email = si.input("# 이메일: ");
            if(!mr.isDuplicateEmail(email)) {
                break;
            }
            System.out.println("중복된 이메일입니다.");
        }

        String name = si.input("# 이름: ");
        String password = si.input("# 패스워드: ");
        String gender = si.input("# 성별: ");
        int age = Integer.parseInt(si.input("# 나이: "));

        System.out.println("# 회원 가입 성공!!");

        // 입력데이터를 기반으로 한 명의 회원 객체를 생성
        Member newMember = new Member(email, password, name, gender, age);

        // 위임 - 관심사의 분리
        mr.addNewMember(newMember);
    }

    // 사용자에게 보여줄 전체 메뉴 화면 출력
    String showProgramMenu() {
        System.out.println("\n##### 회원 관리 시스템 #####");
        if (mr.members.length >= 10) {
        } else {
            System.out.println("* 1. 회원 정보 등록하기");
        }
        System.out.println("* 2. 개별회원 정보 조회하기");
        System.out.println("* 3. 전체회원 정보 조회하기");
        System.out.println("* 4. 비밀번호 변경하기");
        if (mr.members.length == 0) {
        } else {
            System.out.println("* 5. 회원 정보 삭제하기");
        }
        System.out.println("* 6. 회원 정보 복구하기");
        System.out.println("* 7. 프로그램 끝내기");
        System.out.println("=========================");

        String menuNumber = si.input(">> ");
        return menuNumber;
    }

    // 프로그램 종료를 판단하는 입출력
    boolean exitProgram() {
        String exit = si.input("- 프로그램을 종료합니까? [y/n]");
        if (exit.equals("y")) {
            System.out.println("프로그램을 종료합니다.");
            return true;
        } else {
            System.out.println("프로그램 종료를 취소합니다.");
            return false;
        }

    }

    // 이메일 입력받고 찾은 회원정보를 출력
    public void getMember() {
        String inputEmail = si.input("# 조회를 시작합니다!\n# 이메일: ");

        // 이메일이 일치하는 회원이 있는지 조회
        Member foundMember = mr.findMemberByEmail(inputEmail, mr.members);

        if(foundMember != null) {
            System.out.println("========== 조회 결과 ==========");
            System.out.println("# 이름: " + foundMember.memberName);
            System.out.println("# 비밀번호: " + foundMember.password);
            System.out.println("# 성별: " + foundMember.gender);
            System.out.println("# 나이: " + foundMember.age);
            System.out.println();
        } else {
            System.out.println("# 조회된 회원이 없습니다.");
        }
    }

    public void editPassword() {
        String inputEmail = si.input("# 수정할 대상의 이메일: ");

        // 이메일이 일치하는 회원이 있는지 조회
        Member foundMember = mr.findMemberByEmail(inputEmail, mr.members);
        if(foundMember != null) {
            System.out.printf("%s님의 비밀번호를 변경합니다!\n", foundMember.memberName);
            String newPassword = si.input("# 새로운 비밀번호: ");

            foundMember.changePassword(newPassword);

            System.out.println("\n# 비밀번호가 변경되었습니다.\n");
        } else {
            System.out.println("# 조회된 회원이 없습니다.");
        }
    }

    public void deleteMember() {
        if(mr.members.length == 0) return;
        String inputEmail = si.input("# 삭제할 회원의 이메일: ");
        // 이메일이 일치하는 회원이 있는지 조회
        Member foundMember = mr.findMemberByEmail(inputEmail, mr.members);
        // 비밀번호 검증
        String password = si.input("# 비밀번호: ");
        if(!password.equals(mr.findMemberByEmail(inputEmail, mr.members).password)) {
            System.out.println("비밀번호가 틀렸습니다.\n");
            return;
        }

        if(foundMember != null) {
            System.out.printf("%s님의 정보를 정말 삭제합니까?", foundMember.memberName);
            String delete = si.input(" [y/n] : ");
            if (delete.equals("y")) {
                mr.deleteMemberByEmail(inputEmail);
                System.out.println("\n# 회원 탈퇴가 처리되었습니다. 복구하시려면 복구메뉴를 이용하세요.\n");
            }
        } else {
            System.out.println("# 조회된 회원이 없습니다.");
        }
    }

    public void restoreMember() {
        String inputEmail = si.input("# 복구 대상의 이메일: ");

        // 이메일이 일치하는 회원이 있는지 조회
        Member foundMember = mr.findMemberByEmail(inputEmail, mr.restoreList);
        if (foundMember != null) {
            String password = si.input("# 비밀번호: ");
            if(!password.equals(mr.findMemberByEmail(inputEmail, mr.restoreList).password)) {
                System.out.println("# 비밀번호가 틀렸습니다.\n");
            } else {
                mr.restoreMemberByEmail(inputEmail);
                System.out.println("\n# 회원 복구가 처리되었습니다.\n");
            }
        } else {
            System.out.println("# 조회된 회원이 없습니다.");
        }
    }
}
