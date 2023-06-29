import java.util.LinkedList;
import java.util.Scanner;

public class LS_Java_4 {
    public static void main(String[] args) {
        
        LinkedList<String> stringList = new LinkedList<>();

        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.print("> ");
            String command = scan.nextLine();

            if("exit".equals(command)) {
                scan.close();
                break;
            }

            if("print".equals(command)) {
                System.out.println("< " + stringList);
                continue;
            }

            if("revert".equals(command)) {
                stringList.remove();
                System.out.println("< " + stringList);
                continue;
            }

            stringList.addFirst(command);
        }
        System.out.println("Выход");
    }
}
