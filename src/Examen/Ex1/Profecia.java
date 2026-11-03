package Examen.Ex1;

public class Profecia extends Thread{
    private Clau c;

    public Profecia(Clau c) {
        this.c = c;
    }

    @Override
    public void run() {
        for (;;) {
            c.ComprovarProfecia();
            try {
                Thread.sleep((int) (Math.random() * 500));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}