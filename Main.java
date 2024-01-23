package core.ls4;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {
        Employee[] colleague = new Employee[6];
        
        colleague[0] = new Employee(
            "Виктор", "м", "бухгалтер", 80000, 1982, 2, 23);

        colleague[1] = new Employee(
            "Григорий", "м", "менеджер", 40000, 1972, 1, 24);

        colleague[2] = new Employee(
            "Елена", "ж", "менеджер", 40000, 1990, 4, 11);
        
        colleague[3] = new Employee(
            "Наталья", "ж", "Логист", 50000, 1972, 1, 25);
        
        colleague[4] = new Employee(
            "Александр", "м", "Зам руководителя", 75000, 1985, 5, 8);
        
        colleague[5] = new Employee(
            "Виктория", "ж", "Главный Логист", 55000, 1972, 1, 25);
    
        /*
         * В класс покупателя добавить перечисление с гендерами, 
         * внедрить Lombok
         */
        
        Buyer[] clients = new Buyer[6]; 
        
        clients[0] = new Buyer("Сергей", "м", null);
        clients[1] = new Buyer("Виктория", "ж", null);
        clients[2] = new Buyer("Дмитрий", "м", null);
        clients[3] = new Buyer("Александр", "м", null);
        clients[4] = new Buyer("Евгения", "ж", null);
        clients[5] = new Buyer("Александра", "ж", null);

        /*
         * Добавить в основную программу перечисление с праздниками 
         * (нет праздника, Новый Год, 8 марта, 23 февраля), 
         * написать метод, принимающий массив покупателей, 
         * поздравляющий всех сотрудников с Новым Годом, 
         * женщин с 8 марта, а мужчин с 23 февраля, 
         * если сегодня соответствующий день.
         */

        Calendar date = new GregorianCalendar(2023, 2, 8);
        Main.сongratulationsEmployee(colleague, date);

        System.out.println(" ");

        date = new GregorianCalendar(2023, 11, 31);
        Main.сongratulationsEmployee(clients, date);
    }

    public static void сongratulationsEmployee (Employee[] array, Calendar data) {
        SimpleDateFormat formatDate2 = new SimpleDateFormat("MMdd");
        int number = Integer.parseInt(formatDate2.format(data.getTime()));

        for(Employee target: array) {
            if((target.getGender() == "м") && (223 == number)) {
                System.out.printf("Поздравляем %s с %s \n", target.getName(), holidays.FEBRUARY_23.getCompliments());
            } 
            if((target.getGender() == "ж") && (308 == number)) {
                System.out.printf("Поздравляем %s с %s \n", target.getName(), holidays.MARCH_8.getCompliments());
            }
            if(1231 == number) {
                System.out.printf("Поздравляем %s с %s \n", target.getName(), holidays.NEW_YEAR.getCompliments());
            } 
            if((223 != number) && (308 != number) && (1231 != number)) {
                System.out.println(holidays.NO_HOLIDAY.getCompliments());
            }
        }
    }

    public static void сongratulationsEmployee (Buyer[] array, Calendar data) {
        SimpleDateFormat formatDate2 = new SimpleDateFormat("MMdd");
        int number = Integer.parseInt(formatDate2.format(data.getTime()));

        for(Buyer target: array) {
            if((target.getGender() == "м") && (223 == number)) {
                System.out.printf("Поздравляем %s с %s \n", target.getName(), holidays.FEBRUARY_23.getCompliments());
            } 
            if((target.getGender() == "ж") && (308 == number)) {
                System.out.printf("Поздравляем %s с %s \n", target.getName(), holidays.MARCH_8.getCompliments());
            }
            if(1231 == number) {
                System.out.printf("Поздравляем %s с %s \n", target.getName(), holidays.NEW_YEAR.getCompliments());
            } 
            if((223 != number) && (308 != number) && (1231 != number)) {
                System.out.println(holidays.NO_HOLIDAY.getCompliments());
            }
        }
    }

    public enum holidays {
        NO_HOLIDAY ("Нет праздников"),
        NEW_YEAR ("C Новым годом!"),
        MARCH_8 ("C 8 Марта!"),
        FEBRUARY_23 ("C 23 Февраля!");
        
        private String title;
        holidays (String title) {
            this.title = title;
        }

        public String getCompliments() {
            return title;
        }
    } 
}