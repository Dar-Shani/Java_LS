package LS_Java_14;

import java.io.IOException;

public class LS_Java_14 {
    public static void main(String[] args) throws IOException {
        Controller contr = new Controller();
        System.out.println("Добавьте пользователей");
        System.out.println("Например Markov Alexey Viktorovich 1985 12345678 m");
        contr.addUser();
    }
}