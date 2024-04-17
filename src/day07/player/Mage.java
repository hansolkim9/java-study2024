package day07.player;

public class Mage extends Player {

    int mana;

    public Mage(String nickName) {
        this.nickName = nickName;
        this.level = 1;
        this.hp = 50;
        this.mana = 100;
    }

    public void showStatus() {
        super.showStatus();
        System.out.println("# rage: " + this.mana);
    }

    public void thunderbolt(Mage targets) {

    }


}
