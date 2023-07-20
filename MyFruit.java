package LS_Java_10;

public class MyFruit {
    
    static class Fruit {
        private final int weight;
        
        public Fruit(int weight) {
            this.weight = weight;
        }
    
        public int getWeight() {
            return weight;
        }
    }

    static class Orange extends Fruit {
        public Orange(int weight) {
            super(weight);
        }
    }

    static class Apple extends Fruit {
        public Apple(int weight) {
            super(weight);
        }
    }

    static class GoldenApple extends Apple {
        public GoldenApple(int weight) {
            super(weight);
        }
    }
}
