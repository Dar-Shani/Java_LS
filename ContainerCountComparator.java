package LS_Java_9;

import java.util.Comparator;

public class ContainerCountComparator implements Comparator<Container> {
    @Override
    public int compare(Container o1, Container o2) {
        int result = Integer.compare(o1.SizeList(), o2.SizeList());

        if(result > 0) {
            System.out.println("Наибольшее количество коробок в контейнере: " + o1.GetName());
        } else if (result < 0) {
            System.out.println("Наибольшее количество коробок в контейнере: " + o2.GetName());
        } else {
            System.out.println("Контейнеры равны.");
        }

        return result;
    }
}
