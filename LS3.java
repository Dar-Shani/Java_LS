package Lessons.LS3;

public class LS3 {

    public static void main(String[] args) {

        System.out.println(Calculator.sum(23, 27));
        String[] arrayStr = { "12", "2", "32" };
        Integer[] arrayInt1 = { 12, 22, 32 };

        boolean type = compareArrays1(arrayInt1, arrayStr);

        System.out.println(type + " с одинаковым содержимым массивов");

        Pair<Integer, Integer> pair = new Pair<>(123, 321);
        System.out.println("Pair toString() " + pair.toString());

    }

    public static <T> boolean compareArrays1(T[] array1, T[] array2) {
        if (array1.length != array2.length) {
            return false;
        }

        for (int i = 0; i < array1.length; i++) {
            if (!array1[i].getClass().equals(array2[i].getClass())) {
                return false;
            }
        }
        return true;
    }
}