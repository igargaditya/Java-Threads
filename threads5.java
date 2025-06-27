// Implict Lock

class Counter {
    private int count;

    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

class thread extends Thread {
    private Counter counter;

    public thread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++)
            counter.increment();
    }
}

public class threads5 {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        thread t1 = new thread(counter);
        thread t2 = new thread(counter);
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(counter.getCount()); // Doesnt give 2000
    }
}
