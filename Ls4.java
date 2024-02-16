package Lessons.LS4;

import java.util.ArrayList;
import java.util.List;

public class Ls4 {

    public static void main(String[] args) {
        EmployeeDirectory employeeDirectory = new EmployeeDirectory();
        List<Employee> listEmployee;

        employeeDirectory.add(34871, "Евгений", 1290325, 1.11f);
        employeeDirectory.add(10922, "Григорий", 8918976, 6.01f);
        employeeDirectory.add(25678, "Виктория", 5678212, 3.08f);
        employeeDirectory.add(56722, "Ольга", 5671233, 0.08f);

        System.out.println("Ищём 10922: " + employeeDirectory.searchPersonalNumber(10922));

        System.out.println("\n");
        System.out.println("Ищём 5678211");
        listEmployee = new ArrayList<>(employeeDirectory.searchListPhone(5678212));
        showList(listEmployee);

        System.out.println("\n");
        System.out.println("Ищём по стажу 1г 10м");
        listEmployee = new ArrayList<>(employeeDirectory.listExperience(1.10f));
        showList(listEmployee);

    }

    public static void showList(List<Employee> listEmployee) {
        for (Employee list : listEmployee) {
            System.out.println(list.toString());
        }
    }
}