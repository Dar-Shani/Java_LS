public class LS_notebook {
    
    public String brand;
    public String processor;
    public String memory;
    public String colour;
    public String price;

    public void On() {
        System.out.println("Звук включения");
    }

    public void Bios_Info() {
        System.out.printf("Bios - characteristic: processor: %s memory: %s", processor, memory);
    }

    @Override
    public String toString() {
        return brand + " " + processor + " " + memory + " " + colour + " " + price;
    }
}   
