package Threads;

public class Pare_Galetes extends Thread{
    PotGaletes pot;
    String nom;

    public Pare_Galetes(PotGaletes pot, String nom) {
        this.pot = pot;
        this.nom = nom;
    }

    @Override
    public void run() {
        for (;;) {
            try {
                System.out.println("El pare ha deixat una galeta dins el pot.");
                pot.posarGaleta();
                pot.deixarPot();
                Thread.sleep((int) (Math.random() * 800) + 100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
