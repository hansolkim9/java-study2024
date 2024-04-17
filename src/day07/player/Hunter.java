package day07.player;

public class Hunter extends Player {

    int concentration;

    public Hunter(String nickName) {
        this.nickName = nickName;
        this.level = 1;
        this.hp = 50;
        this.concentration = 10;
    }

    public void showStatus() {
        super.showStatus();
        System.out.println("# rage: " + this.concentration);
    }

    public void multipleArrow(Hunter target) {

    }
}
