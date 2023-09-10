package LS_Lottery;

import java.io.IOException;
import java.util.Scanner;

public class Lottery {
    public static void main(String[] args) throws InterruptedException, IOException {
        Scanner scanner = new Scanner(System.in);
        Viev viev = new Viev();
        Model model = new Model();  
        boolean isRunning = true;

        model.loadingResources();
        viev.content(" ");
        viev.mainMenu();
        

        while (isRunning != false) {
            System.out.print("команда: ");
            String command = scanner.nextLine();
            viev.clear();

            if("1".equals(command)) {
                viev.content("> создание");
                viev.creationMenu();
                model.addToy(command = scanner.nextLine());
                viev.clear();
                System.out.println("+ " + model.lastIndex);
            }
            if ("2".equals(command) && Toy.count > 0) {
                viev.clear();
                viev.content("> список");
                model.getToy();
            }
            if ("3".equals(command) && Toy.count > 0) {
                viev.clear();
                viev.content("> редактирование шанса");
                model.getToy();
                System.out.print("Укажите номер игрушки ");
                int namber = scanner.nextInt();
                System.out.print("Укажите новое значение ");
                int editChance = scanner.nextInt();
                model.editChanceToWin(namber, editChance);
            }
            if ("4".equals(command) && Toy.count > 0) {
                viev.clear();
                viev.content("> лотерея");
                model.getToy();
                viev.targetInfo();
                command = scanner.nextLine();
                model.lottery(Integer.parseInt(command));
            }

            if("exit".equals(command)) {
                scanner.close();
                isRunning = false;
            } 
        }  
    }
}