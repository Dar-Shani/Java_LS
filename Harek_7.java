public class Harek_7 extends Animals_7 {
    private String name;
    private String type;
    private int age;

    public Harek_7 (String _name, String _type, int age) {
        this.name = _name;
        this.type = _type;
        this.age = age;

        super.nutrition = "хищник";
        super.size = "очень маленький";
        super.satiety = 20;
    }

    public Harek_7 (String _name) {
        this.name = _name;
        this.type = "харёк";
        this.age = 1;

        super.nutrition = "хищник";
        super.size = "очень маленький";
        super.satiety = 20;
    }

    @Override
    public String toString() {
        return "Имя " + name + ", тип " + type + ", возраст " + age + " " + nutrition + ", размер " + size + ", сытость " + super.satiety;
    }

    @Override
    public void Walking() {
        System.out.print("бесшумный топ-топ-топ");
    }
}
