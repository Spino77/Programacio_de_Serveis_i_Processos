package Threads.TallerCostura;

public class Cosidora extends Thread {
    private String nom;
    private Cistell cistell;

    public Cosidora(Cistell cistell, String nom) {
        this.cistell = cistell;
        this.nom = nom;
    }

    @Override
    public void run() {
        for (;;) {
            try {
                System.out.println(nom + " esta cosint.");
                Thread.sleep((long) (Math.random() * 2000) + 400);
                cistell.depositar();
                cistell.deixar();
                System.out.println(nom + " ha depositat al cistell.");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}