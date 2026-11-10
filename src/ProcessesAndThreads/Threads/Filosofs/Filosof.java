package Threads.Filosofs;

public class Filosof extends Thread{
    public Cobert cobert1;
    public Cobert cobert2;
    public String nom;


    public Filosof(Cobert c1, Cobert c2, String nom) {
        this.cobert1 = c1;
        this.cobert2 = c2;
        this.nom = nom;
    }

    @Override
    public void run() {
        for (; ; ) {
            try {
                //agafa els dos coberts i menja (sleep) una estona
                cobert1.agafar();
                cobert2.agafar();
                System.out.println(nom + " esta menjat.");
                Thread.sleep((long) (Math.random() * 2000) + 400);
                //deixar coberts
                cobert1.deixar();
                cobert2.deixar();
                //pensar (sleep)
                System.out.println(nom + " ha acabat de menjar i es posa a pensar.");
                Thread.sleep((long) (Math.random() * 2000) + 400);
                System.out.println(nom + " ha acabat de pensar.");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}