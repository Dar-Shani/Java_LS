package LS_Java_10;
import java.util.ArrayList;
import java.util.List;
import LS_Java_10.MyFruit.Fruit;

public class Box<T extends Fruit> {

    private List<T> fruList;
    private int weight;

    public Box() {
        this.fruList = new ArrayList<>();
    }
    
    public void add(T fruit) {
        this.fruList.add(fruit);
        this.weight += fruit.getWeight();
    }

    public int getWeight() {
        return this.weight;
    }

    public void moveTo(Box<T> box) {
        box.add(this.fruList.get(fruList.size() - 1));
        this.weight -= fruList.get(fruList.size() - 1).getWeight();
        fruList.remove(fruList.size() - 1);
    }
    
}
