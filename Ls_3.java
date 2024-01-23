package core_ls_3;
import java.util.*;

public class Ls_3 {
    public static void main(String[] args) {
        /*
         * 1. Написать прототип компаратора - метод внутри класса сотрудника, 
         * сравнивающий две даты, представленные в виде трёх чисел гггг-мм-дд, 
         * без использования условного оператора.
         */

        Employee[] colleague = new Employee[6];
        
        colleague[0] = new Employee(
            "Виктор", "бухгалтер", 80000, 1982, 2, 23);

        colleague[1] = new Employee(
            "Григорий", "менеджер", 40000, 1972, 1, 24);

        colleague[2] = new Employee(
            "Елена", "менеджер", 40000, 1990, 4, 11);
        
        colleague[3] = new Employee(
            "Наталья", "Логист", 50000, 1972, 1, 25);
        
        colleague[4] = new Employee(
            "Игорь", "Зам руководителя", 75000, 1985, 5, 8);
        
        colleague[5] = new Employee(
            "Виктория", "Главный Логист", 55000, 1972, 1, 25);

        System.out.println("Сортировка по дате рождения:");

        Arrays.sort(colleague);
        System.out.println(Arrays.toString(colleague));

        /*
         * 2. Опишите класс руководителя, наследник от сотрудника. 
         * Перенесите статический метод повышения зарплаты в класс руководителя, 
         * модифицируйте метод таким образом, чтобы он мог поднять заработную плату всем, 
         * кроме руководителей. В основной программе создайте руководителя и поместите его в 
         * общий массив сотрудников. Повысьте зарплату всем сотрудникам и проследите, 
         * чтобы зарплата руководителя не повысилась.
         */
        System.out.println("\n\n");

        colleague[4] = new Supervisor(
            "Игорь", "Руководитель", 100000, 1985, 5, 8);

        colleague[2] = new Supervisor(
            "Виктория", "Руководитель", 10000, 1972, 1, 25);

        Supervisor supervisor1 = (Supervisor) colleague[4];
        supervisor1.raiseTheSalary(colleague[2], 5000);
        supervisor1.raiseTheSalary(colleague[0], 5000);

        System.out.println("\n");
        
        for(Employee num: colleague) {
            num.getInfo();
        }















    }
    
}