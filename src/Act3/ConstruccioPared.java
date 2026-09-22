package Act3;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ConstruccioPared {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(4);

        Paleta p1 = new Paleta();
        Paleta p2 = new Paleta();
        Paleta p3 = new Paleta();
        Paleta p4 = new Paleta();

        executor.execute(p1);
        executor.execute(p2);
        executor.execute(p3);
        executor.execute(p4);
        executor.shutdown();

        System.out.println("fet");
    }
}

//paletas han de construir una pared
//un paleta es un process (clase) -> es runnable i que fa pasar un temps (sleep(math.random()))
//programa fer pared en el que es crea un numero de paletas i posarlos a executar tots a la vegada amb execute