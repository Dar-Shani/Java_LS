package Work3;
//Нарушен 2 Принцип открытости\закрытости
//приватную переменную formality сделал final, добавил конструктор.
public class Main {
    public static void main(String[] args) {
        Greeter greeter = new Greeter("formal");
        System.out.println(greeter.greet());

        //greeter.setFormality("intimate");
        //System.out.println(greeter.greet());
    }
}
