package Lessons.LS5;

public class Fork {
    private String name;

    Fork(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void forkUp(Philosopher philosopher) {
        System.out.println(philosopher.getName() + " взял " + name);
    }
}
