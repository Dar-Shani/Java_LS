public class Cat_7 extends Animals_7 {
    private String name;
    private String type;
    private int age;


    public Cat_7 (String _name, String _type, int age) {
        this.name = _name;
        this.type = _type;
        this.age = age;

        super.nutrition = "хищник";
        super.size = "маленький";
        super.satiety = 20;
    }

    public Cat_7 (String _name) {
        this.name = _name;
        this.type = "кошка";
        this.age = 3;

        super.nutrition = "хищник";
        super.size = "маленький";
        super.satiety = 20;
    }

    @Override
    public void Voice () {
        System.out.print("Мяукает ");
    }

    @Override
    public String toString() {
        return "Имя " + name + ", тип " + type + ", возраст " + age + " " + nutrition + ", размер " + size + ", сытость " + super.satiety;
    } 
}
