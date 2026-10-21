package Threads.TallerCostura;

public class Cistell {
    private int capacitat = 0;
    private int capacitat_max;
    private boolean disponible;

    public Cistell(int capacitat_max, boolean disponible) {
        this.capacitat_max = capacitat_max;
        this.disponible = disponible;
    }

    public synchronized void depositar() throws InterruptedException {
        while (capacitat == capacitat_max) wait();
        disponible = false;
        capacitat += 1;
        notifyAll();
    }

    public synchronized void agafar(int quantitat) throws InterruptedException {
        while (capacitat == 0) wait();
        disponible = false;
        capacitat -= quantitat;
        notifyAll();
    }

    public synchronized void deixar() {
        disponible = true;
        notifyAll();
    }
}