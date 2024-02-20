package Lessons.LS5;

public class Philosopher extends Thread {
    private String name;

    private Fork forkA;
    private Fork forkB;
    private int count;
    private long start;
    private long stop;

    Philosopher(String name, Fork forkA, Fork forkB) {
        this.name = name;
        this.forkA = forkA;
        this.forkB = forkB;
    }

    public String getNameP() {
        return name;
    }

    /*
     * private void takeFork() {
     * synchronized (forkA) {
     * // System.out.println(name + " взял " + forkA.getName());
     * synchronized (forkB) {
     * try {
     * count++;
     * System.out.println(name + " взял " + forkA.getName()
     * + " " + forkB.getName() + " начал трапезничать "
     * + count + ":3");
     * sleep(1000);
     * } catch (InterruptedException e) {
     * e.printStackTrace();
     * }
     * }
     * }
     * }
     */
    private void takeFork2() {
        if (!Thread.holdsLock(forkA)) {
            synchronized (forkA) {
                if (!Thread.holdsLock(forkB)) {
                    synchronized (forkB) {
                        try {
                            sleep(100);
                            count++;
                            System.out.println(name + " взял " + forkA.getName()
                                    + " " + forkB.getName() + " начал трапезничать "
                                    + count + ":3");
                        } catch (InterruptedException e) {

                            e.printStackTrace();
                        }
                    }
                } else {
                    System.out.println(name + " неуспел взять " + forkB.getName()
                            + " поэтому вернул " + forkA.getName());
                    return;
                }
            }
        } else {
            System.out.println(name + " неуспел взять " + forkA.getName());
            return;
        }
    }

    @Override
    public void run() {
        start = System.currentTimeMillis();
        while (count <= 2) {
            // takeFork();
            takeFork2();
        }
        stop = System.currentTimeMillis();
        long time = stop - start;
        System.out.println("\n" + name + " пообедал за " + time + "\n");

    }

}
