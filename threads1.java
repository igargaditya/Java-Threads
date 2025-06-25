class thread_one extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName());
        }
    }
}

class thread_two implements Runnable {
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName());
        }
    }
}

public class threads1 {
    public static void main(String[] args) {
        // To make thread when extends Threads
        thread_one t1 = new thread_one();
        t1.start();

        // To make thread when implements Runnable
        thread_two obj2 = new thread_two();
        Thread t2 = new Thread(obj2);
        t2.start();

        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName());
        }
    }
}
