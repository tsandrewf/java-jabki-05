// 1) Класс «Кошелек»:
public class Wallet {
    private String owner;
    private double money;

    public Wallet(String owner, double money) {
        this.owner = owner;
        this.money = Math.max(money, 0);
    }

    public Wallet(String owner) {
        this(owner, 0);
    }

    public Wallet(double money) {
        this("Неизвестный", money);
    }

    public Wallet() {
        this(0);
    }

    public String getOwner() {
        return this.owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public double getMoney() {
        return this.money;
    }

    public void setMoney(double money) {
        if (0 <= money) {
            this.money = money;
        }
    }

    public void spend(int amount) {
        if ((amount >= 0) && amount <= this.money) {
            this.money -= amount;
        }
    }
}
