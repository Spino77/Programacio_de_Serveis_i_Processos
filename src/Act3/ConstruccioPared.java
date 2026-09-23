package Act3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ConstruccioPared {
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(4);

        List<Paleta> paletas = new ArrayList<>();

        long timeCurrent = System.currentTimeMillis();

        for (int i = 0; i < 4; i++) {
            Paleta paleta = new Paleta();
            paletas.add(paleta);
        }

        for (int i = 0; i < paletas.size(); i++) {
            executor.execute(paletas.get(i));
        }

        executor.shutdown();
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);

        long timeFinal = System.currentTimeMillis();

        System.out.println("Pared construida en: " + ((timeFinal - timeCurrent) / 1000) + " segons");
    }
}

//paletas han de construir una pared
//un paleta es un process (clase) -> es runnable i que fa pasar un temps (sleep(math.random()))
//programa fer pared en el que es crea un numero de paletas i posarlos a executar tots a la vegada amb execute