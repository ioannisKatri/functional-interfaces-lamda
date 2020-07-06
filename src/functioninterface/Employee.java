package functioninterface;

public class Employee extends Person {

    private int money;


    public Employee(String name, int age) {
        super(name, age);
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

}
