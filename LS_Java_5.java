import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class LS_Java_5 {
    public static void main(String[] args) {
        
        System.out.println("Телефонный справочник \nВведите help для справки");

        Scanner scan = new Scanner(System.in);
        
        int id = 0;
        Map<Integer, Map<String, List<String>>> cl = new HashMap<>();

        String[] commandList;

        while(true) {
            
            String command = scan.nextLine();

            commandList = Determinant(command);
            
            if("ADD".equals(commandList[0])) {
                id += 1;
                cl.put(id, Add_contact(commandList));
            }

            if("GET".equals(commandList[0])) {
                Get_contact(cl, commandList[1]);
            }

            if("REMOVE".equals(commandList[0])) {
                if(Remove_contact(cl, commandList[1]) == true) {
                    System.out.println("Для подтверждения удаления введите ID номер ");
                    int del = scan.nextInt();
                    cl.remove(del);
                    System.out.println("Данные удалены.");
                } else {
                    System.out.println("Не найдена запись с фамилией " + commandList[1]);
                }
            }

            if("LIST".equals(commandList[0])) {
                List_contact(cl);
            }
            
            if("help".equals(commandList[0])) Information();

            if ("EXIT".equals(command)) break;  
        }
        scan.close();
        System.out.println("Выход с программы");
    }

    static void Information() {
        System.out.println("[ADD] Ivanov 88005553535 88005553536 - ADD добавить запись");
        System.out.println("[GET] Ivanov - получить список всех номеров");
        System.out.println("[REMOVE] Ivanov - удалить все номера");
        System.out.println("[LIST] - просмотр всех записей");
        System.out.println("[EXIT] - выход с программы");
        System.out.println("Вводить без скобок и через пробел");
    }

    static String[] Determinant(String text) {
        String[] alText = text.split(" ");
        return alText;
    }
    
    static Map<String, List<String>> Add_contact(String[] list) {
        Map<String, List<String>> inner_sheet = new HashMap<>();
        LinkedList<String> listA = new LinkedList<>();
        
        for(int a = 2; a < list.length; a ++) {
            listA.add(list[a]);
        }
        
        inner_sheet.put(list[1], listA);
        return inner_sheet;
    }

    static void Get_contact(Map<Integer, Map<String, List<String>>> _cl, String _name) {
        boolean target = false;
        for(var itemA: _cl.keySet()) {
            Map<String, List<String>> listB = _cl.get(itemA);
            for(var itemB: listB.keySet()) {
                if(_name.equals(itemB)) {
                    System.out.println(itemB + " " + listB.get(itemB));
                    target = true;
                }
            }
        }
        if(target == false) System.out.println("Не найдена запись с фамилией " + _name);
    }

    static boolean Remove_contact(Map<Integer, Map<String, List<String>>> _cl ,String _name) {
        boolean target = false;
        for(var itemA: _cl.keySet()) {
            Map<String, List<String>> listB = _cl.get(itemA);
            for(var itemB: listB.keySet()) {
                if(_name.equals(itemB)) {
                    System.out.println("ID: " + itemA + " " + itemB + " " + listB.get(itemB));
                    target = true;
                }
            }
        }
        return target;
    }

    static void List_contact(Map<Integer, Map<String, List<String>>> _cl) {
        for(var itemA: _cl.keySet()) {
            Map<String, List<String>> listB = _cl.get(itemA);
            for(var itemB: listB.keySet()) {
                System.out.println(itemB + " " + listB.get(itemB));
            }
        }
    }
}