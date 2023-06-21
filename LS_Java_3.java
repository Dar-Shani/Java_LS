import java.util.ArrayList;
import java.util.Collections;

public class LS_Java_3 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Collections.addAll(list, 11,8,15,19,7,2,5,9,1,10,14,2,4,3, 12);

        System.out.println("Дано: " + list);
        System.out.println("Максимальное значение: " + MaxValue(list));
        System.out.println("Минимальное значение: " + MinValue(list));
        MediumValue(list);
        list = SortArray(list);
        System.out.println("Итого: " + list);



    }

    static int MaxValue(ArrayList<Integer> _list) {
        int max = 0;

        for(int item: _list) {
            if(item > max) {
                max = item;
            }
        }

        return max;
    }
    
    static int MinValue(ArrayList<Integer> _list) {
        int max = Integer.MAX_VALUE;

        for(int item: _list) {
            if(item < max) {
                max = item;
            }
        }

        return max;
    }

    static void MediumValue(ArrayList<Integer> _list) {
        Collections.sort(_list);
        System.out.println("Отсортированно: " + _list);
        
        int number = _list.size() / 2;
        
        if(_list.size() % 2 == 0) {
            System.out.println("Среднее значение: " + _list.get(number) + "\n");
        } else {
            System.out.printf("Средние значения: %d : %d \n", _list.get(number), _list.get(number + 1));
        }
    }

    static ArrayList<Integer> SortArray (ArrayList<Integer> _list) {
        
        for(int i = 0; i < _list.size(); i++) {
            if(_list.get(i) % 2 == 0) {
                System.out.println("удалён: " + _list.get(i));
                _list.remove(i);
                i -= 1;
            }
        } 
        return _list;
    }
}
