package LS_Java_13;
//import java.lang.Exception;
import java.util.Scanner;

public class LS_Java_13_4 {
    public static void main(String[] args) {
        
        System.out.println("Заполните заметку: ");
        try {
            System.out.println(addNote());
        } catch (Exception e) {
            System.err.println("Ошибка " + e.getMessage());
        }
        
        



    }

    public static String addNote() throws Exception {
        Scanner scanner = new Scanner(System.in);
        String note = scanner.nextLine();
        scanner.close();
        if(note.trim().isEmpty()) {
            throw new Exception("Пустую строку вводить нельзя");
        }
        return note;
    }
}
