import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.Optional;

public class Homework {
    public static void main(String[] args) {
        List<Departament> departaments = Arrays.asList(new Departament("департамент 1"),
                new Departament("департамент 2"), new Departament("департамент 3"));

        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Виктор", 20, 51000, departaments.get(0)));
        persons.add(new Person("Александра", 30, 55000, departaments.get(0)));
        persons.add(new Person("Евгений", 28, 52000, departaments.get(0)));
        persons.add(new Person("Оксана", 29, 52000, departaments.get(0)));
        persons.add(new Person("Дмирий", 28, 51000, departaments.get(0)));

        persons.add(new Person("Владимир", 45, 67000, departaments.get(1)));
        persons.add(new Person("Александр", 23, 37000, departaments.get(1)));
        persons.add(new Person("Виктория", 25, 50000, departaments.get(1)));
        persons.add(new Person("Виктория", 27, 51000, departaments.get(1)));
        persons.add(new Person("Евгения", 29, 51000, departaments.get(1)));

        persons.add(new Person("Евгения", 43, 55000, departaments.get(2)));
        persons.add(new Person("Александра", 27, 52000, departaments.get(2)));
        persons.add(new Person("Григорий", 29, 58000, departaments.get(2)));
        persons.add(new Person("Дмитрий", 27, 55000, departaments.get(2)));
        persons.add(new Person("Александр", 26, 51000, departaments.get(2)));

        printNamesOrdered(persons);
        System.out.println("");

        Map<Homework.Departament, Homework.Person> worker = printDepartmentOldestPerson(persons);
        System.out.println(worker);
        System.out.println("");

        List<Person> persons1 = findFirstPersons(persons);
        persons1.stream().forEach(System.out::println);
        System.out.println("");

        Optional<Map.Entry<Departament, Double>> topDepartament = findTopDepartament(persons);
        System.out.println(topDepartament);
    }

    // Вывести на консоль отсортированные (по алфавиту) имена персонов
    public static void printNamesOrdered(List<Homework.Person> persons) {
        persons.stream()
                .sorted((o1, o2) -> o1.getName().compareTo(o2.getName()))
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    /**
     * В каждом департаменте найти самого взрослого сотрудника.
     * Вывести на консоль мапипнг department -> personName
     * Map<Department, Person>
     */
    public static Map<Homework.Departament, Homework.Person> printDepartmentOldestPerson(
            List<Homework.Person> persons) {
        Map<Homework.Departament, Homework.Person> employee = persons.stream()
                .collect(Collectors.groupingBy(Person::getDepartament,
                        Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Person::getAge)),
                                Optional::get)));
        return employee;
    }

    // Найти 10 первых сотрудников, младше 30 лет, у которых зарплата выше 50_000
    public static List<Homework.Person> findFirstPersons(List<Homework.Person> persons) {
        return persons.stream()
                .filter(p -> p.getSalary() >= 50000 && p.getAge() < 30)
                .limit(10)
                .toList();
    }

    // Найти депаратмент, чья суммарная зарплата всех сотрудников максимальна
    // Optional<Homework.Departament>
    public static Optional<Map.Entry<Homework.Departament, Double>> findTopDepartament(List<Homework.Person> persons) {
        return persons.stream()
                .collect(Collectors.groupingBy(Person::getDepartament,
                        Collectors.summingDouble(Person::getSalary)))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue());
    }

    static class Person {

        private String name;
        private int age;
        private double salary;
        private Departament departament;

        Person(String name, int age, double salary, Departament departament) {
            this.name = name;
            this.age = age;
            this.salary = salary;
            this.departament = departament;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public double getSalary() {
            return salary;
        }

        public Departament getDepartament() {
            return departament;
        }

        @Override
        public String toString() {
            return name + ", возраст " + age + ", зп " + salary + ", " + departament.getName();
        }

    }

    static class Departament {
        private String name;

        Departament(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
