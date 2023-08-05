package LS_Java_13;

import java.util.Scanner;

public class LS_Java_13 {
    public static void main(String[] args) {

        System.out.println("Введите число float");
        float number = returnFractionalNumber();
        System.out.println(number);     
        
    }

    public static float returnFractionalNumber() {
        Scanner scanner = new Scanner(System.in);
        float inputNumber = -1f;

        while (inputNumber == -1f) {
            try {
                inputNumber = scanner.nextFloat();
            } catch (Exception e) {
                System.out.println("Некоректный ввод");
                scanner.nextLine();
            }
        }
        scanner.close();
        return inputNumber;
    }

    
    
}
