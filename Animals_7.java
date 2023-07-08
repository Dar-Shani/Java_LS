public class Animals_7 {
    
    protected String nutrition;
    protected String size;
    protected int satiety;
     

    public void Voice () {
        System.out.print("Пищит ");
    }

    public void Walking () {
        System.out.print("Еле заметный топ-топ-топ");
    }

    public int Eats() {
        Voice();
        Walking();
        satiety += 80;
        System.out.println("");
        return satiety;
    }
}
