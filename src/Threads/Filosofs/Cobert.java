package Threads.Filosofs;

public class Cobert {
    boolean disponible;

    public Cobert(Boolean disponible) {
        this.disponible = disponible;
    }


    public synchronized void agafar() throws InterruptedException {
        if (!disponible) wait();
        disponible = false;
        notifyAll();
    }


    public synchronized void deixar() {
        disponible = true;
        notifyAll();
    }



}
