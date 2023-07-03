import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class LS_Java_6 {
    


public static void main(String[] args) {
    
    String[] optionBook = new String[] {"Acer", "Asus", "Hasee", "Infinix", 
        "Intel Celeron N5095", "Intel Core i3", "AMD Ryzen 5", "Intel Core i5",
        "4","6","8","12", "Red", "Black", "Blue", "Green",
        "36608","47450","66330","59481"};

        ArrayList<LS_notebook> variants_Notebooks = new ArrayList<>();

        for(int i = 0; i < 6; i++) {
            variants_Notebooks.add(BuiLs_notebook(Option_Random(optionBook)));
        }

        System.out.println("Дано ");
        for(var item: variants_Notebooks) {
            System.out.println(item.toString());
        }
        
        System.out.println("Выберите условия сортировки \nПримеры поиска");
        System.out.println("m 4 - Поиск по объёму оперативной памяти");
        System.out.println("c red - Поиск по цвету");
        System.out.println("p 30000 - Поиск по максимальной цене");

        Scanner scan = new Scanner(System.in);
        String[] command = scan.nextLine().split(" ");
        
        Search(command, variants_Notebooks);

        scan.close();
    }
    static String[] Option_Random(String[] option) {

        Random random = new Random();

        String[] variation = new String[] {option[random.nextInt(3 - 0 + 1) + 0], 
        option[random.nextInt(7 - 4 + 1) + 4], option[random.nextInt(11 - 8 + 1) + 8],
        option[random.nextInt(15 - 12 + 1) + 12], option[random.nextInt(19 - 16 + 1) + 16]};

        return variation;
    }
    
    static LS_notebook BuiLs_notebook (String[] component) {
        LS_notebook notebook = new LS_notebook();
        notebook.brand = component[0];
        notebook.processor = component[1];
        notebook.memory = component[2];
        notebook.colour = component[3];
        notebook.price = component[4];
        return notebook;
    }
    
    static void Search(String[] array, ArrayList<LS_notebook> notebooks) {
        for(var itemA: notebooks) {

            if("m".equals(array[0]) && array[1].equals(itemA.memory)) {
                System.out.println(itemA.toString());
            }

            if("c".equals(array[0]) && array[1].equals(itemA.colour)) {
                System.out.println(itemA.toString());
            }

            if("p".equals(array[0])) {
                int target = Integer.parseInt(array[1]);
                int price = Integer.parseInt(itemA.price);

                if(price <= target) System.out.println(itemA.toString());
            }
        }
    }
}