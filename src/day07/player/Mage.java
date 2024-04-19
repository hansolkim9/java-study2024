package day07.player;

public class Mage extends Player {

    int mana;

    public Mage(String nickName) {
        super(nickName);
        this.mana = 100;
    }

    public void showStatus() {
        super.showStatus();
        System.out.println("# rage: " + this.mana);
    }

    public void thunderbolt(Player... targets) {
        // 여기에 코드 작성
        System.out.printf("# %s님 썬더볼트 시전!!!!", this.nickName);
        System.out.println("\n==============================");
        for (Player target : targets) {
            if (target != this) { // 자기 자신이 아닌 대상에게만 공격
                int damage = (int) (Math.random() * 6) + 10; // 10부터 15까지의 랜덤한 피해
                target.hp -= damage;
                System.out.println(target.nickName + "님이 " + damage + "의 피해를 입었습니다. (남은 체력: " + target.hp +")");
            }
        }
    }


}
