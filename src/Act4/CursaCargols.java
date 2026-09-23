package Act4;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CursaCargols {
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(4);

        Cargol c1 = new Cargol("Cargol 1");
        Cargol c2 = new Cargol("Cargol 2");

        executor.scheduleWithFixedDelay(c1, 3, 2, TimeUnit.SECONDS);
        executor.scheduleWithFixedDelay(c2, 5, 1, TimeUnit.SECONDS);
        executor.awaitTermination(15, TimeUnit.SECONDS);
        executor.shutdown();
        System.out.println(c1.getNom() + ": " + c1.getMetres() + " metres");
        System.out.println(c2.getNom() + ": " + c2.getMetres() + " metres");

        if (c1.getMetres() > c2.getMetres()) {
            System.out.println(c1.getNom() + " ha guanyat la cursa.");
        } else {
            System.out.println(c2.getNom() + " ha guanyat la cursa.");
        }
    }
}