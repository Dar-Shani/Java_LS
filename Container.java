package LS_Java_9;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Container implements Comparable<Container>, Iterable<Box> {
    private int wt;

    List<Box> component;
    int index;
    private String name;
    
    public Container(String _name) {
        this.component = new ArrayList<>();
        this.index = 0;
        this.name = _name;
    }

    public void AddComponent() {
        this.component.add(index, new Box());
        this.wt += GetWeight();
        this.index++;
    }

    public int SizeList() {
        return this.component.size();
    }

    private int GetWeight() {
        return this.component.get(index).GetWeight();
    }

    public int GetWt() {
        return this.wt;
    }

    public String GetName() {
        return this.name;
    }

    @Override
    public Iterator<Box> iterator() {
        return this.component.iterator();
    }

    @Override
    public int compareTo(Container o) {
        int result = Integer.compare(this.wt, o.wt);

        if(result > 0) {
            System.out.println("Наибольший контейнер: " + this.name);
        } else if (result < 0) {
            System.out.println("Наибольший контейнер: " + o.name);
        } else {
            System.out.println("Контейнеры равны.");
        }

        return result;
    }
}
