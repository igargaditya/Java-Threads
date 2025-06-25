class prioritythreads extends Thread {
    public prioritythreads(String name) {
        super(name);
    }

    @Override
    public void run() {
        // try {
        // Thread.sleep(10000);
        // } catch (InterruptedException e) {
        // System.out.println("Interrupt Called " + e);
        // }
        for (int i = 0; i <= 10; i++) {
            System.out.println(Thread.currentThread().getName() + " -> " + Thread.currentThread().getPriority());
        }
    }
}

class yieldthreads extends Thread {
    public yieldthreads(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i <= 10; i++) {
            System.out.println(Thread.currentThread().getName() + "->" + i);
            Thread.yield();
        }
    }
}

public class threads3 {
    public static void main(String[] args) {

        prioritythreads t1 = new prioritythreads("High Priority");
        prioritythreads t2 = new prioritythreads("Medium Priority");
        prioritythreads t3 = new prioritythreads("Low priority");

        // Setting the priorities but since multicore in any order executed
        // t1.setPriority(Thread.MAX_PRIORITY);
        // t2.setPriority(Thread.NORM_PRIORITY);
        // t3.setPriority(Thread.MIN_PRIORITY);
        // t1.start();

        // t2.start();
        // t3.start();

        // t1.interrupt();

        yieldthreads t4 = new yieldthreads("t4");
        yieldthreads t5 = new yieldthreads("t5");
        t4.start();
        t5.start();

    }
}
