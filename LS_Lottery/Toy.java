package LS_Lottery;

public class Toy {
    private int id;
    private String name;
    static int count;
    private int chanceToWin;
    static int totalWeight;

    Toy (String name, int chanceToWin) {
        this.id = count;
        this.name = name;
        count ++;
        this.chanceToWin = chanceToWin;
        totalWeight += chanceToWin;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getChanceToWin() {
        return this.chanceToWin;
    }

    public void setChanceToWin(int chanceToWin) {
        this.chanceToWin = chanceToWin;
    }

    @Override
    public String toString() {
        return "ID " + this.id + " название " + this.name + " шанс " + this.chanceToWin;
    }
}
