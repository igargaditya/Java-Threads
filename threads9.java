// Read Write Lock - 2 Readers can acquire lock at same write but 2 writers cant and also if a writer has a writer lock then reader lock cant be acquired 

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class threadread extends Thread {
    private ReadWriteLock cnt;

    threadread(ReadWriteLock cnt) {
        this.cnt = cnt;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " count : " + cnt.getCount());
        }
    }
}

class threadwrite extends Thread {
    private ReadWriteLock cnt;

    threadwrite(ReadWriteLock cnt) {
        this.cnt = cnt;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            cnt.increment();
            System.out.println(Thread.currentThread().getName() + " incremented count");

        }
    }
}

class ReadWriteLock {
    private int count = 0;
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    private final Lock readLock = lock.readLock();
    private final Lock writelock = lock.writeLock();

    public void increment() {
        writelock.lock();
        try {
            count++;
            Thread.sleep(100);
        } catch (InterruptedException e) {

        } finally {
            writelock.unlock();
        }
    }

    public int getCount() {
        readLock.lock();
        try {
            return count;
        } finally {
            readLock.unlock();
        }

    }

}

public class threads9 {
    public static void main(String[] args) throws InterruptedException {
        ReadWriteLock counter = new ReadWriteLock();
        threadwrite writer = new threadwrite(counter);
        threadread reader1 = new threadread(counter);
        threadread reader2 = new threadread(counter);

        writer.start();
        reader1.start();
        reader2.start();

        writer.join();
        reader1.join();
        reader2.join();

    }
}
