package Threads;

public class PotGaletes {
    private boolean disponible;
    private int galetes;

    public PotGaletes(int galetes) {
        this.galetes = galetes;
    }

    public synchronized void agafarGaleta() throws InterruptedException {
        while (galetes <= 0 && !disponible) wait();
        disponible = false;
        galetes --;
        System.out.println("Galetes actuals: " + galetes);
        notifyAll();
    }

    public synchronized void posarGaleta() throws InterruptedException {
        while (galetes > 0 && !disponible) wait();
        disponible = false;
        galetes = 10;
        System.out.println("Galetes actuals: " + galetes);
        notifyAll();
    }

    public synchronized void deixarPot() {
        disponible = true;
        notifyAll();
    }


}
