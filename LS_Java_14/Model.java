package LS_Java_14;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Model implements WorkingWithAProfile {

    private User user;
    
    @Override
    public User addProfile() throws IOException {
        try(Scanner scanner = new Scanner(System.in)) {
            String inputUser = scanner.nextLine();
            String[] userComponent = inputUser.split(" ");
            
            if(userComponent.length > 6) {
                System.err.println("Введенно больше данных");
                throw new IndexOutOfBoundsException(userComponent.length);
            }

            if(userComponent.length != 6) {
                throw new IOException("Заполнены не все данные");
            }

            if(!userComponent[0].matches("[a-zA-Z]+")) {
                System.err.println("Фамилия должна состоять только из букв");
                throw new NumberFormatException(userComponent[0]);
            }

            if(!userComponent[1].matches("[a-zA-Z]+")) {
                System.err.println("Имя должно состоять только из букв");
                throw new NumberFormatException(userComponent[1]);
            }

            if(!userComponent[2].matches("[a-zA-Z]+")) {
                System.err.println("Отчество должно состоять только из букв");
                throw new NumberFormatException(userComponent[2]);
            }

            if(!userComponent[3].matches("\\d{2}\\.\\d{2}\\.\\d{4}")) {
                System.err.println("Неверный формат для даты рождения");
                throw new NumberFormatException(userComponent[3]);
            }

            if(!userComponent[4].matches("\\d{8}")) {
                System.err.println("Неверный формат для номера телефона");
                throw new NumberFormatException(userComponent[4]);
            }

            if(!userComponent[5].equals("f") && !userComponent[5].equals("m")) {
                System.err.println("Неверно указан пол");
                throw new NumberFormatException(userComponent[5]);
            }



            user = new User(userComponent[0], userComponent[1], 
            userComponent[2], userComponent[3], 
            userComponent[4], userComponent[5]);
            
            return user; 
        } 
    }

    @Override
    public void SaveProfile(User user) {
        try(BufferedWriter fWriter = new BufferedWriter(new FileWriter(user.getUserSurname(), true))) {
            fWriter.write(user.getInfoUser());
            fWriter.newLine();
        } catch (Exception e) {
            System.out.println("Ошибка при создании и записи файла");
            e.printStackTrace();
        }
    }

}
