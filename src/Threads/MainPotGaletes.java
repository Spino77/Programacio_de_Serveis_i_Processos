package Threads;

public class MainPotGaletes {
    public static void main(String[] args) {
        PotGaletes pot = new PotGaletes(10);
        Pare_Galetes pare = new Pare_Galetes(pot,"Pare");
        Fill_Galetes fill1 = new Fill_Galetes(pot, "Fill1");
        Fill_Galetes fill2 = new Fill_Galetes(pot, "Fill2");
        Fill_Galetes fill3 = new Fill_Galetes(pot, "Fill3");

        pare.start();
        fill1.start();
        fill2.start();
        fill3.start();


    }
}