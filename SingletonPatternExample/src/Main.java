package src;
public class Main {
    public static void main(String[] args) {

        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("First log message");
        logger2.log("Second log message");

        // Verify same instance
        if (logger1 == logger2) {
            System.out.println("Same instance — Singleton works!");
        }
    }
}