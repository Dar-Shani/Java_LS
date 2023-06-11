import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Scanner;


public class LS_Java_1 {
    public static void main(String[] args) {
        /*1. Задать одномерный массив и найти в нем минимальный 
        и максимальный элементы ;*/
        int[] arr = new int[] {8,3,10,6,9,14,7,29,11};       
        int max = arr[0];
        int min = arr.length;

        System.out.println("ЗД 1, дано " + Arrays.toString(arr));  

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > max)
                max = arr[i];
            
            if(arr[i] < min)
                min = arr[i];        
        }
        
        System.out.printf("Зд 1: макс %d мин %d", max, min);

        /*2. Создать квадратный двумерный целочисленный массив 
        (количество строк и столбцов одинаковое), 
        и с помощью цикла(-ов) заполнить его диагональные элементы единицами 
        (можно только одну из диагоналей, если обе сложно). 
        Определить элементы одной из диагоналей можно по следующему 
        принципу: индексы таких элементов равны, 
        то есть [0][0], [1][1], [2][2], …, [n][n]; */

        int[][] array = {
            {0,0,0,0},
            {0,0,0,0},
            {0,0,0,0},
            {0,0,0,0}
        };

        int numberA = 0;
        int numberB = 0;

        System.out.println(" /n");
        for(int a = 0; a <= 3; a++) {
            for(int b = 0; b <= 3; b++) {
                if(a == numberA & b == numberB) {
                    array[a][b] = 1;
                    numberA ++;
                    numberB ++;
                }
                System.out.print(array[a][b] + " ");
            }
            System.out.println(" ");
        }
        
        /*В консоли запросить имя пользователя. В зависимости от текущего времени, 
        вывести приветствие вида:
        "Доброе утро, <Имя>!", если время от 05:00 до 11:59
        "Добрый день, <Имя>!", если время от 12:00 до 17:59;
        "Добрый вечер, <Имя>!", если время от 18:00 до 22:59;
        "Доброй ночи, <Имя>!", если время от 23:00 до 4:59 */

        LocalDateTime time = LocalDateTime.now();
        int hour = time.getHour();
        int minute = time.getMinute();
        String response = "";

        Scanner scan = new Scanner(System.in);
        System.out.println("Имя? ");
        String name = scan.nextLine();
        scan.close();

        if (hour > 4 & hour < 12) {
            response = "Доброе утро,";
        }
        
        if (hour > 11 & hour < 18) {
            response = "Добрый день,";
        }

        if (hour > 17 & hour < 23) {
            response = "Добрый вечер,";
        }

        if (hour > 22 & hour < 5) {
            response = "Доброй ночи,";
        }

        System.out.printf("Время %d:%d %s %s", hour, minute, response, name);











    }
}
