package com.example;

import java.util.ArrayList;

import org.apache.commons.math3.random.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Boolean> player1 = new ArrayList<>(drawing(false));
        ArrayList<Boolean> player2 = new ArrayList<>(drawing(true));

        long statistics1 = player1.stream().filter(Boolean::booleanValue).count();
        long statistics2 = player2.stream().filter(Boolean::booleanValue).count();

        int losses1 = 1000 - (int) statistics1;
        int losses2 = 1000 - (int) statistics2;

        System.out.println("Статистика упрямого игрока "
                + statistics1 + " побед: " + losses1 + " проигрышей");
        System.out.println("Статистика игрока который постоянно менял решения "
                + statistics2 + " побед: " + losses2 + " проигрышей");

    }

    public static ArrayList<Boolean> drawing(boolean a) {
        RandomDataGenerator selection = new RandomDataGenerator();
        ArrayList<Boolean> list = new ArrayList<>();
        int car, playerChoice, mastersChoice;

        for (int i = 0; i < 1000; i++) {
            car = selection.nextInt(1, 3);
            playerChoice = selection.nextInt(1, 3);
            mastersChoice = selection.nextInt(1, 3);

            if (a == true) {
                do {
                    mastersChoice = selection.nextInt(1, 3);
                } while (playerChoice == mastersChoice || car == mastersChoice);

                do {
                    playerChoice = selection.nextInt(1, 3);
                } while (playerChoice == mastersChoice);
            }
            if (playerChoice == car) {
                list.add(true);
            } else {
                list.add(false);
            }

        }

        return list;
    }
}