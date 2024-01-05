package core_ls_2;
import java.util.Arrays;

public class ls_2 {
    public static void main(String[] args) {

        /* Написать метод, возвращающий количество чётных элементов массива. 
         * countEvens([2, 1, 2, 3, 4]) → 3 countEvens([2, 2, 0]) → 3 countEvens([1, 3, 5]) → 0
         */

        int[] countEvens = {2, 1, 2, 3, 4};

        System.out.println("Зд 1: количество чётных элементов равно " + evenNumbers(countEvens));
        

        /* Написать функцию, возвращающую разницу между самым большим и 
         *самым маленьким элементами переданного не пустого массива. 
         */
        
        System.out.println("Зд 2: разница между макс и мин значением равна " + valueDifference(countEvens));


        /* Написать функцию, возвращающую истину,      
         * если в переданном массиве есть два соседних элемента, с нулевым значением. 
         */
        int[] arrays = {0, 1, 2, 3, 4, 0, 0, 1, 2, 34};
        System.out.println("Зд 3: данно " + Arrays.toString(arrays) + " поиск соседних нулевых ячеек " + findingNullValues(arrays));


    }
    //1
    public static int evenNumbers (int[] array) {
        int count = 0;
        
        for (int i: array) {
           if (i %  2 == 0) {
            count ++;
           }
        }
        return count;
    }

    //2
    public static int valueDifference (int[] array) {
        if (array == null) {
            return 404;
        } else {
            int difference = Arrays.stream(array).max().getAsInt() - Arrays.stream(array).min().getAsInt();
            return difference;
        }
    }

    //3
    public static boolean findingNullValues (int[] array) {
        for(int i = 0; i < array.length; i++) {
            if (array[i] == 0 && array[i+1] == 0) {
                return true;
            }
        }
        return false;
    }
}
