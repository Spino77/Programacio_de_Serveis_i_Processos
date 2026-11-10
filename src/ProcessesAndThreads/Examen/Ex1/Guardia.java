package ProcessesAndThreads.Examen.Ex1;

public class Guardia extends Thread{
    private Clau c;

    public Guardia(Clau c) {
        this.c = c;
    }

    @Override
    public void run() {
        for (;;) {
            try {
                System.out.println("Guardia espera");
                c.obrir();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}