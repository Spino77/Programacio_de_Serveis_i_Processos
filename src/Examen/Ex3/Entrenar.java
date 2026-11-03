package Examen.Ex3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Entrenar {
    public static void main(String[] args) throws InterruptedException {
        int numJugadors = 11;
        int numEntrenos = 5;
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(11);

        // Instanciem els jugadors
        List<Jugador> jugadors = new ArrayList<>();

        // Comencem a contar el temps
        long ti = System.currentTimeMillis();

        // Donem nom als jugadors i els posem a jugar els partits
        for (int i = 0; i < numJugadors; i++) {
            jugadors.add(new Jugador("Jugador-" + i, numEntrenos));
        }

        for (int i = 0; i < numJugadors; i++) {
            executor.execute(jugadors.get(i));
        }
        executor.shutdown();
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);

        // Han acabat i agafem el temps final
        long te = System.currentTimeMillis();

        System.out.println("Han trigat: " + (te - ti) + " segons");
    }
}
