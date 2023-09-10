package LS_Lottery;
import java.io.IOException;

public class Viev {
    Model model = new Model();


    public void content(String text) {
        System.out.println("Главное " + text);
        System.out.println("Загруженно " + Toy.count + " Игрушек\n\n\n");
    }

    public void creationMenu() {
        System.out.println("Шаблон- Название   %в ед");
        System.out.println("Пример: медвежонок 25 50");
    }

    public void mainMenu() {
        System.out.println("1 Добавить игрушку");
        System.out.println("2 Показать список доступных игрушек");
        System.out.println("3 Изменить процент выйгрыша всех игрушек данного типа");
        System.out.println("4 Лотерея");
    }

    public void targetInfo() {
        System.out.println("Укажите номер игрушки для розыгрыша");
    }

    public void clear() throws InterruptedException, IOException {
        new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
    }

}
