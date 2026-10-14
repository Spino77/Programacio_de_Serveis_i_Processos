package Threads;

public class Fill_Galetes extends Thread {
    PotGaletes pot;
    String nom;

    public Fill_Galetes(PotGaletes pot, String nom) {
        this.pot = pot;
        this.nom = nom;
    }

    @Override
    public void run() {
        for (;;) {
            try {
                System.out.println("Fill " + nom + " s'ha menjat una galeta.");
                pot.agafarGaleta();
                Thread.sleep((int) (Math.random() * 300) + 100);

                pot.deixarPot();
                Thread.sleep((int) (Math.random() * 800) + 100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


        }

    }
}
