package core_ls_3;

public class Supervisor extends Employee {

    Supervisor(String name, String post, int salary, int yy, int mm, int dd) {
        super(name, post, salary, yy, mm, dd);
    }

    public void raiseTheSalary(Employee target, int salary) {
        if(target.getPost().equals(super.getPost())) {
            System.out.println("Руководству зп повысить может только директор");
        } else {
            target.setSalary(salary);
            System.out.printf("%s повысил зп - %s %s на %d", getPost(), target.getPost(), target.getName(), salary);
        }
    }
    
}
