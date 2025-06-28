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
    }
}
