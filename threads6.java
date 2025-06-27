import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Bank {
    private int balance = 110;
    private Lock lock = new ReentrantLock();

    public void withdraw(int amount) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " Attempting !! ");
        try {
            if (lock.tryLock(3100, TimeUnit.MILLISECONDS)) {
                try {
                    if (balance >= amount) {
                        System.out.println(Thread.currentThread().getName() + " is withdrawing amount ->" + amount);
                        Thread.sleep(3000);
                        balance -= amount;
                        System.out.println(
                                Thread.currentThread().getName() + " Completed Withdraw and remaining balance is->"
                                        + balance);

                    } else {
                        System.out.println(" Insuffcient Balance->" + balance);
                    }
                } catch (Exception e) {
                    Thread.currentThread().interrupt();

                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println(Thread.currentThread().getName() + " Couldn't Acquire the lock, Come back later ");
            }
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
    }
}

class thread extends Thread {
    public Bank bank;
    int amount;

    thread(String name, Bank bank, int amount) {
        super(name);
        this.bank = bank;
        this.amount = amount;
    }

    @Override
    public void run() {
        try {
            bank.withdraw(amount);
        } catch (InterruptedException e) {
        }
    }
}

public class threads6 {
    public static void main(String[] args) {
        Bank sbi = new Bank();

        thread t1 = new thread("t1", sbi, 50);
        thread t2 = new thread("t2 ", sbi, 50);
        t1.start();
        t2.start();

    }
}
