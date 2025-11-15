
import java.util.*;
public class InterruptExample {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted!");
            }
        });
        t.start();
        t.interrupt(); // Interrupt while sleeping
        System.out.println("Thread interrupted? " + t.isInterrupted());
    }
}
