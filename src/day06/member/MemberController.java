package day06.member;

import util.SimpleInput;

import java.sql.SQLOutput;

// 역할: 사용자의 메뉴 입력을 분기하는 역할
public class MemberController {

    MemberView mv;
    SimpleInput si;

    MemberController() {
        this.mv = new MemberView();
        this.si = new SimpleInput();
    }
    // 메뉴입력 분기에 따라 할 일을 나눠주는 기능
    void run() {

        while(true) {
            String menuNum = mv.showProgramMenu();

            switch (menuNum) {
                case "1":
                    mv.inputNewMember();
                    break;
                case "2":
                    // 이메일을 입력받아서 회원 개별조회 해주는 코드
                    mv.getMember();
                    break;
                case "3":
                    mv.showMembers();
                    break;
                case "4":
                    // 이메일을 입력받아서 회원 비밀번호를 수정하는 코드
                    mv.editPassword();
                    break;
                case "5":
                    // 이메일을 입력받아서 회원 정보 삭제하는 코드
                    mv.deleteMember();
                    break;
                case "6":
                    boolean flag = mv.exitProgram();
                    if (flag) return;
            } // end switch
            si.stopInput();
        } // end while
    }
}
