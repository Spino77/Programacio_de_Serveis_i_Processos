package Threads;

public class PotGaletes {
    private boolean disponible = true;
    private int galetes;

    public PotGaletes(int galetes) {
        this.galetes = galetes;
    }

    public synchronized void posarGaleta() throws InterruptedException {
        while (!disponible) wait();
        if (galetes <= 0) {
            disponible = false;
            System.out.println("El pare ha omplert el pot de galetes.");
            galetes = 10;
            System.out.println("Galetes actuals: " + galetes);
            notifyAll();
        }
    }

    public synchronized void agafarGaleta() throws InterruptedException {
        while (!disponible || galetes == 0) wait();
        disponible = false;
        galetes --;
        System.out.println("Galetes actuals: " + galetes);
        notifyAll();
    }

    public synchronized void deixarPot() {
        disponible = true;
        notifyAll();
    }


}
