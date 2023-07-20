package LS_Java_10;
import LS_Java_10.MyFruit.Apple;
import LS_Java_10.MyFruit.GoldenApple;
import LS_Java_10.MyFruit.Orange;

public class LS_Java_10 {
    public static void main(String[] args) {
        

        Box<Orange> orangeBox = new Box<>();
        orangeBox.add(new Orange(2));
        orangeBox.add(new Orange(4));
        //orangeBox.add(new Apple(5)); //не проходит
        //orangeBox.add(new GoldenApple(5)); //не проходит
        System.out.println("Ящик с апельсинами, вес " + orangeBox.getWeight());

        Box<Apple> appleBox = new Box<>();
        appleBox.add(new Apple(5));
        appleBox.add(new GoldenApple(4));
        System.out.println("Ящик с яблоками, вес " + appleBox.getWeight());

        Box<GoldenApple> goldenAppleBox = new Box<>();
        goldenAppleBox.add(new GoldenApple(4));
        //goldenAppleBox.add(new Apple(5)); //не проходит
        System.out.println("Ящик с золотыми яблоками, вес " + goldenAppleBox.getWeight());

        System.out.println();

        Box<Orange> orangeBox2 = new Box<>();
        System.out.println("Первый ящик с апельсинами, вес " + orangeBox.getWeight());
        orangeBox.moveTo(orangeBox2);
        System.out.println("Первый ящик после того как пересыпали часть, вес " + orangeBox.getWeight());
        System.out.println("Второй ящик с апельсинами " + orangeBox2.getWeight());













        
    }
}
