package Threads;

public class MembreFamilia extends Thread{
    Comandament com;
    String nom;

    public MembreFamilia(Comandament com, String nom) {
        this.com = com;
        this.nom = nom;
    }

    @Override
    public void run() {
        for (;;) {
            try {
                //agafar el comandament
                com.agafar();
                System.out.println(nom + " esta mirant la tele");
                //mirar la televisió
                Thread.sleep((int) (Math.random() * 300) + 100);
                //deixar el comandament
                com.deixar();
                //descansar
                Thread.sleep((int) (Math.random() * 500) + 100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}

