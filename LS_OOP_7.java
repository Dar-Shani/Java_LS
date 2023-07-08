import java.util.Random;

public class LS_OOP_7 {
    


    public static void main(String[] args) {
        String[] arrayName = new String[] {"Граф  ","Мухтар","Балбес",
        "Фу    ","Рекс  ","Фрам  ","Гоша  "};

        Animals_7[] packAnimals = new Animals_7[9];
        for(int i = 0; i < packAnimals.length; i++) {
            packAnimals[i] = RandomAnimals(arrayName);
        }
        
        System.out.println("Данно: ");
        PrintAnimals(packAnimals);

        food dish = new food(2000);
    
        System.out.println("\n\n\n\nКормим");
        Animals_7 animal;
        for(int b = 0; b < packAnimals.length; b++) {
            animal = packAnimals[b];
            dish.ExpensesFood(animal.Eats());
        }

        System.out.println("\n\nПокормили");
        PrintAnimals(packAnimals);

    }

    static Animals_7 RandomAnimals(String[] _name) {

        Random random = new Random();
        int randomNumber = random.nextInt(4 - 1 + 1) + 1;

        Animals_7 animal;
        switch (randomNumber) {
            case 1:
            animal = new Cat_7(_name[random.nextInt(6 - 0 + 1) + 0]);
            return animal;
            
            case 2:
            animal = new Dog_7(_name[random.nextInt(6 - 0 + 1) + 0]);
            return animal;
            
            case 3:
            animal = new Harek_7(_name[random.nextInt(6 - 0 + 1) + 0]);
            return animal;
            
            case 4:
            animal = new Parrot_7(_name[random.nextInt(6 - 0 + 1) + 0]);
            return animal;

            default:
            return null;
        }
    }

    static void PrintAnimals(Animals_7[] pack) {
        for(int a = 0; a < pack.length; a++) {
            System.out.println(a + " " + pack[a].toString());
        }
    }
}
