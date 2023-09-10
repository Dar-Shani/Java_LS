package LS_Lottery;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.io.File;


public class Model {

    private ArrayList<Toy> toyList = new ArrayList<>();

    public int lastIndex;
    File file = new File("data.csv");
    

    public void loadingResources() {
        if(file.exists()) {
            readerData();
        }
    }

    private void readerData() {
        String[] list;
        try(BufferedReader readerCSV = new BufferedReader(new FileReader("data.csv"))) {
            String text;
            while((text = readerCSV.readLine()) != null) {
                list = text.split(",");
                toyList.add(new Toy(list[0], list[1], Integer.parseInt(list[2]))); 
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void addToy(String text) {
        lastIndex = Toy.count;
        String[] specifications = text.split(" ");
        System.out.println(Arrays.toString(specifications));
        for(int a = 1; a <= Integer.parseInt(specifications[2]); a++) {
            toyList.add(new Toy(specifications[0], Integer.parseInt(specifications[1])));
        }
        
        saveToy(lastIndex, "data.csv");
    }

    private void saveToy(int number, String file) {
        try(FileWriter createCSV = new FileWriter(file, true)) { 
            for(int a = number; a < toyList.size(); a++) {
                Toy toy = toyList.get(a);
                createCSV.append(toy.getId());
                createCSV.append(",");
                createCSV.append(toy.getName());
                createCSV.append(",");
                createCSV.append(Integer.toString(toy.getChanceToWin()));
                createCSV.append("\n");
            }
        } catch(IOException e) {
            e.printStackTrace();
        }  
    }

    public void getToy() {
        for(Toy toy: toyList) {
            System.out.println(toy);
        }
    }

    public void editChanceToWin(int namber, int chance) {
        String target = toyList.get(namber).getName();
        for(Toy toy: toyList) {
            if(target.equals(toy.getName())) {
                toy.setChanceToWin(chance);
            }
        }
        file.delete();
        saveToy(0, "data.csv");
    }

    public void lottery(int number) {
        
        Toy targetToy = toyList.get(number);
        
        Random random = new Random();

        int lot = random.nextInt(Toy.totalWeight) + 1;
        System.out.println(lot);
        if(targetToy.getChanceToWin() + 5 > lot && targetToy.getChanceToWin() - 5 < lot) {
            System.out.println("Выйгрышь, приз добавлен в список");
            savePrize(targetToy);
            toyList.remove(number);
            Toy.count--;
            file.delete();
            saveToy(0, "data.csv");  
        }
    }

    private void savePrize(Toy toy) {
        try(FileWriter createCSV = new FileWriter("Prize.csv", true)) { 
            createCSV.append(toy.getId());
            createCSV.append(",");
            createCSV.append(toy.getName());
            createCSV.append(",");
            createCSV.append(Integer.toString(toy.getChanceToWin()));
            createCSV.append("\n");
        } catch(IOException e) {
            e.printStackTrace();
        }  
    }

}
