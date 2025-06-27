
// Reentrant locks 
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class threads7 {
    private final Lock lock = new ReentrantLock();

    public void outermethod() {
        lock.lock();
        try {
            System.out.println("Outer Method Runs");
            innermethod();
        } finally {
            lock.unlock();
        }
    }

    public void innermethod() {
        lock.lock();

        try {
            System.out.println("Inner Method Runs");

        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        threads7 t1 = new threads7();
        t1.outermethod();
    }
}
