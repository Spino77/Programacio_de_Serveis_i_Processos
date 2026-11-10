package ProcessesAndThreads.Examen.Ex1;

public class Clau {
    public int valor_profecia = 3;
    private boolean profecia_complerta = false;

    public synchronized void ComprovarProfecia() {
        int random = (int) (Math.random() * 10);
        System.out.println(random);
        if (random == valor_profecia) {
            profecia_complerta = true;
            System.out.println("Profecia complerta");
        }
        notifyAll();
    }

    public synchronized void obrir() throws InterruptedException {
        while (!profecia_complerta) wait();
        System.out.println("El guardia ha entrat a la torre");
        System.exit(1);
        notifyAll();
    }
}