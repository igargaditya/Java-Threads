// Daemon Threads 

class daemonthread extends Thread {
    public daemonthread(String name) {
        super(name);
    }

    public void run() {
        while (true) {
            System.out.println(1);
        }
    }
}

public class threads4 {
    public static void main(String[] args) {
        daemonthread t1 = new daemonthread("t1");
        t1.setDaemon(true);
        t1.start();
        // Even though while 1 loop but still doesnt run infinitely
        System.out.println("Main Threads Ends");

    }
}
