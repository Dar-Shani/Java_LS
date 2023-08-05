package LS_Java_13;
//import java.lang.NullPointerException;
//import java.lang.IndexOutOfBoundsException;
import java.io.FileNotFoundException;

public class LS_Java_13_2_3 {



    //                  ЗД 2
/*       try {
            int d = 2; //на 0 не делиться
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
         } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
         }*/
//                       Зд 3


    public static void main(String[] args) throws Exception {
    
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = { 1, 2 };
            abc[1] = 9; // в изначальном варианте он выходил за пределы массива.
        
        } catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        } catch (Throwable ex) { //это надо было ниже всех ловить.
            System.out.println("Что-то пошло не так...");
        }
    }

    public static void printSum(Integer a, Integer b) throws FileNotFoundException {
        System.out.println(a + b);
}

}
