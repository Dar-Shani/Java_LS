package Lessons.LS5;

public class LS5 {
    public static void main(String[] args) {
        Fork forkAB = new Fork("AB");
        Fork forkEA = new Fork("EA");
        Fork forkBC = new Fork("BC");
        Fork forkCD = new Fork("CD");
        Fork forkDE = new Fork("DE");

        Philosopher philosopher1 = new Philosopher("Филосов А", forkAB, forkEA);
        Philosopher philosopher2 = new Philosopher("Филосов Б", forkEA, forkBC);
        Philosopher philosopher3 = new Philosopher("Филосов С", forkBC, forkCD);
        Philosopher philosopher4 = new Philosopher("Филосов Д", forkCD, forkDE);
        Philosopher philosopher5 = new Philosopher("Филосов Е", forkDE, forkEA);

        Thread thread1 = new Thread(philosopher1);
        Thread thread2 = new Thread(philosopher2);
        Thread thread3 = new Thread(philosopher3);
        Thread thread4 = new Thread(philosopher4);
        Thread thread5 = new Thread(philosopher5);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }
}
