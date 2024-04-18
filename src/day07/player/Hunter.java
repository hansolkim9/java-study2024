package day07.player;

public class Hunter extends Player {

    int concentration;

    public Hunter(String nickName) {
        super(nickName);
        this.concentration = 10;
    }

    public void showStatus() {
        super.showStatus();
        System.out.println("# rage: " + this.concentration);
    }

    public void multipleArrow(Hunter target) {

    }
}
