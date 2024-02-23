package Lessons.LS3;

public class Pair<T1, T2> {
    private T1 firstT1;
    private T2 secondT2;

    Pair(T1 firstT1, T2 secondT2) {
        this.firstT1 = firstT1;
        this.secondT2 = secondT2;
    }

    public T1 getFirst() {
        return firstT1;
    }

    public T2 getSecond() {
        return secondT2;
    }

    @Override
    public String toString() {
        return firstT1 + " " + secondT2;
    }
}
