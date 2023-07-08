public class Dog_7 extends Animals_7 {
    private String name;
    private String type;
    private int age;

    public Dog_7 (String _name, String _type, int age) {
        this.name = _name;
        this.type = _type;
        this.age = age;

        super.nutrition = "хищник";
        super.size = "Средний";
        super.satiety = 20;
    }

    public Dog_7 (String _name) {
        this.name = _name;
        this.type = "собака";
        this.age = 3;

        super.nutrition = "хищник";
        super.size = "средний";
        super.satiety = 20;
    }

    @Override
    public void Voice () {
        System.out.print("Лает ");
    }

    @Override
    public String toString() {
        return "Имя " + name + ", тип " + type + ", возраст " + age + " " + nutrition + ", размер " + size + ", сытость " + super.satiety;
    } 

    @Override
    public void Walking() {
        System.out.print("топ-топ-топ");
    }
}
