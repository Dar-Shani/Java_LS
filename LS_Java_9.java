package LS_Java_9;

public class LS_Java_9 {
    public static void main(String[] args) {
        Container c1 = new Container("Красный");
        c1.AddComponent();
        c1.AddComponent();
        c1.AddComponent();
        c1.AddComponent();
        
        Container c2 = new Container("Жёлтый");
        c2.AddComponent();
        c2.AddComponent();
        c2.AddComponent();

        ContainerCountComparator count = new ContainerCountComparator();

        System.out.println("Сравниваем вес " + c1.compareTo(c2));
        System.out.println("Сравниваем по количеству ящиков " + count.compare(c1, c2));


        
        

    }
}

