
import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

public class LS_Java_2 {
    public static void main(String[] args) {
       /*
        * 1) Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, используя StringBuilder. Данные для фильтрации приведены ниже в виде json-строки.
        Если значение null, то параметр не должен попадать 
        в запрос.
        Параметры для фильтрации: 
        {"name":"Ivanov", "country":"Russia", 
        "city":"Moscow", "age":"null"}
        */

       
        String list = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";
        System.out.println("ЗД 1 Дано: " + list);
        
        StringBuilder command = new StringBuilder("ЗД 1 Итого: ");
        command.append(FilterCommand(list));
        System.out.println(command);
        

        /*2) Реализуйте алгоритм сортировки пузырьком числового
         массива, результат после каждой итерации запишите в лог-файл. */

        int[] listA = {7,9,10,3,1,4,8,5,2,6};
        System.out.println("ЗД 2 Дано: " + Arrays.toString(listA));
        try {
            Logger sortLogger = Logger.getLogger("SortLoger");
            FileHandler fileLog = new FileHandler("log.xml");
            XMLFormatter xmlLog = new XMLFormatter();
            fileLog.setFormatter(xmlLog);
            sortLogger.addHandler(fileLog);
            Sort(listA, sortLogger);
        } catch (Exception a) {

        }
    
    }

    public static StringBuilder FilterCommand(String text) {
        StringBuilder fcommand = new StringBuilder();
        text = text.replaceAll("[,{}\"]", "");
        String[] flist = text.split(" ");
        
        for(int i = 0; i < flist.length; i++) {
            
            if(flist[i].contains("null")) {
                flist[i] = null;
            }
        }
        
        text = Arrays.toString(flist);
        text = text.replace("null", "");
        fcommand.append(text);
        
        return fcommand;
    }

    public static void Sort(int[] list, Logger log) {
        for(int a = 0; a < list.length - 1; a++) {
            for(int b = 0; b < list.length - a - 1; b++) {
                if(list[b] > list[b + 1]) {
                    log.info("Итераторы " + a + b);
                    
                    int count = list[b];
                    log.info("Итераторы " +"a: "+ a +" b: "+ b);
                    
                    list[b] = list[b + 1];
                    log.info("list[b]: " + list[b]);                  

                    list[b + 1] = count;
                    log.info("list[b + 1]: " + list[b + 1]);
                }
            }
        }
        System.out.println("ЗД 2: Лог файл записан");
    }
}
