package core_ls_3;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class Employee implements Comparable<Employee>{
    private String name;
    private String post;
    private int salary;
    private Calendar date1;

    private SimpleDateFormat formatDate1 = new SimpleDateFormat("yyyy MM dd");

    Employee (String name, String post, int salary, int yy, int mm, int dd) {
        this.name = name;
        this.post = post;
        this.salary = salary;
        date1 = new GregorianCalendar(yy, mm, dd);
    }

    public void getInfo() {
        System.out.printf("Имя %s, должность %s, зп %d, дата рождения %s \n",
        name, post, salary, formatDate1.format(date1.getTime()));
    }

    public void setSalary(int count) {
        this.salary += count;
    } 

    public int getDate() {
        return Integer.parseInt(formatDate1.format(date1.getTime()).
        replace(" ", ""));
    }

    public String getName() {
        return this.name;
    }

    public String getPost() {
        return this.post;
    }

    @Override
    public int compareTo(Employee emp) {
        return Integer.compare(this.getDate(), emp.getDate());
    }

    @Override
    public String toString() {
        return name + " " + formatDate1.format(date1.getTime());
    }
}
