package Threads.TallerCostura;

public class Encadellador extends Thread {
    private String nom;
    private Cistell cistell1;
    private Cistell cistell2;

    public Encadellador(String nom, Cistell cistell1, Cistell cistell2) {
        this.nom = nom;
        this.cistell1 = cistell1;
        this.cistell2 = cistell2;
    }

    @Override
    public void run() {
        for (;;) {
            try {
                cistell1.agafar(2);
                cistell1.deixar();
                cistell2.agafar(1);
                cistell2.deixar();
                System.out.println(nom + "ha agafat els materials necesaris.");
                Thread.sleep((long) (Math.random()* 1000) + 100);
                System.out.println(nom + " ha acabat un jersei.");

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }



    }
}
