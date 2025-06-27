// Fareness of Locks 

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class thread extends Thread {
    FairnessExample example = new FairnessExample();

    thread(FairnessExample example) {
        this.example = example;
    }

    @Override
    public void run() {
        example.accessResource();
    }
}

class FairnessExample {
    private final Lock lock = new ReentrantLock(true); // Ensures Fairness

    public void accessResource() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " Acquired the lock");
            Thread.sleep(1000);
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        } finally {
            System.out.println("Lock is released");
            lock.unlock();
        }
    }
}

public class threads8 {
    public static void main(String[] args) {
        FairnessExample example = new FairnessExample();
        thread t1 = new thread(example);
        thread t2 = new thread(example);
        thread t3 = new thread(example);

        // t2.start();
        t3.start();
        t2.start();
        t1.start();

    }
}
