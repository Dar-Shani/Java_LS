package LS_Lottery;
import java.util.UUID;

public class Toy {
    private UUID id;
    private String name;
    static int count;
    private int chanceToWin;
    static int totalWeight;

    Toy (String name, int chanceToWin) {
        this.id = UUID.randomUUID();
        this.name = name;
        count ++;
        this.chanceToWin = chanceToWin;
        totalWeight += chanceToWin;
    }

    Toy (String id,String name, int chanceToWin ) {
        this.id = UUID.fromString(id);
        this.name = name;
        count ++;
        this.chanceToWin = chanceToWin;
        totalWeight += chanceToWin;
    }

    public String getId() {
        return this.id.toString();
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
