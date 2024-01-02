package Java_Core_LS_1;
import java.util.Scanner;

public class Note {

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        Recorded writeR = new Recorded();

        String note = "On";
        

        while (!note.equalsIgnoreCase("exit")) {
            System.out.print("Введите заметку: ");
            note = scan.nextLine();
            if (!note.equalsIgnoreCase("exit")) {
                writeR.writterText(note);
            }
        }
        scan.close();
    }
}
