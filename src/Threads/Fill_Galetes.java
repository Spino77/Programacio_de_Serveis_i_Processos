package Threads;

public class Fill_Galetes extends Thread {
    PotGaletes pot;
    String nom;

    public Fill_Galetes(PotGaletes pot, String nom) {
        this.pot = pot;
        this.nom = nom;
    }

    @Override
    public synchronized void run() {
        for (;;) {
            try {
                pot.agafarGaleta();
                System.out.println("Fill " + nom + " s'ha menjat una galeta.");

                Thread.sleep((int) (Math.random() * 300) + 100);

                pot.deixarPot();
                Thread.sleep((int) (Math.random() * 800) + 100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


        }

    }
}
