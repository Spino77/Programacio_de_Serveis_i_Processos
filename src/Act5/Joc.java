package Act5;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Joc {
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(4);
        List<Punts> llista = new ArrayList<>();

        int numJugadors = 4;
        for (int i = 0; i < numJugadors; i++) {
            Jugador jugador = new Jugador(String.valueOf(i + 1));
            Punts punts = new Punts(jugador);
            llista.add(punts);
        }

        for (int i = 0; i < numJugadors; i++) {
            long varTems = (long) (Math.random() * 10 + 1);
            executor.scheduleWithFixedDelay(llista.get(i), 1, varTems, TimeUnit.SECONDS);
        }

        executor.awaitTermination(10, TimeUnit.SECONDS);
        executor.shutdown();

        int guanyador = 1;
        for (int i = 0; i < numJugadors; i++) {
            System.out.println("Jugador " + (i + 1) + " ha aconseguit: " + llista.get(i).jugador.getPunts() + " punts.");
            if (llista.get(i).jugador.getPunts() > llista.get(guanyador).jugador.getPunts()) {
                guanyador = i;
            }
        }
        System.out.println("Jugador " + (guanyador + 1) + " ha guanyat amb: " + llista.get(guanyador).jugador.getPunts() + " punts.");
    }
}

//clase jugador amb nom i punts (no es un proces)
//hi ha un proces que esta relacionat amb el jugador i li dona punts (Math.random())
//joc (main) que tindra un executor que donara punts al jugador i quan acabi fa un ranking