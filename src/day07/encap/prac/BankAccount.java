package day07.encap.prac;

public class BankAccount {

//            - 잔액 조회, 입금, 출금 메소드를 public으로 만들어 외부에서 접근할 수 있게 하세요.
//            - 출금 메소드는 잔액이 출금하려는 금액보다 클 때만 돈을 출금할 수 있도록 하세요.

    private int balance; // 계좌 잔액
    private String accountNumber; // 계좌 번호
    private String accountHolder; // 계좌 주인의 이름

    // 생성자
    BankAccount(String accountNumber, String accountHolder, int balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // 잔액 조회를 위한 getter
    public int getBalance() {
        return balance;
    }

    // 입금 메서드
    public void deposit (int money) {
        if (money < 0) {
            System.out.println("유효하지 않은 금액입니다. 0 이상의 금액을 입력해주세요.");
            return ;
        }
        balance += money;
    }

    // 출금 메서드
    public int withdraw (int money) {
        if (balance > money && money > 0) {
            balance -= money;
            return balance;
        } else {
            System.out.println("출금에 실패했습니다.");
            return balance;
        }
    }




}

