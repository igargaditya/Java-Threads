public class threads11 {
    public static void main(String[] args) {

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Using Anonymous Inner class");
            }
        };

        Runnable r2 = () -> {
            System.out.println("Using Lambda Expression");
        };

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
    }
}
