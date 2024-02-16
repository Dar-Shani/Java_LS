package Lessons.LS4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeDirectory {
    private Map<Integer, Employee> employees = new HashMap<>();

    public void add(int personnelNumber, String name, int phoneNumber, float experience) {
        employees.put(personnelNumber, new Employee(name, personnelNumber, phoneNumber, experience));
    }

    public String searchPersonalNumber(int personnelNumber) {
        return employees.get(personnelNumber).toString();
    }

    public List<Employee> searchListPhone(int phoneNumber) {
        List<Employee> listSearch = new ArrayList<>(employees.values());
        listSearch.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                int phoneNumber1 = Math.abs(o1.getPhoneNumber() - phoneNumber);
                int phoneNumber2 = Math.abs(o2.getPhoneNumber() - phoneNumber);
                return Integer.compare(phoneNumber1, phoneNumber2);
            }
        });
        return listSearch;
    }

    public List<Employee> listExperience(float experience) {
        List<Employee> listSearch = new ArrayList<>(employees.values());
        listSearch.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                float experience1 = Math.abs(o1.getExperience() - experience);
                float experience2 = Math.abs(o2.getExperience() - experience);
                return Float.compare(experience1, experience2);
            }
        });
        return listSearch;
    }
}
