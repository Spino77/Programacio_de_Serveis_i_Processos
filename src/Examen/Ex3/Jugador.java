package Examen.Ex3;

import java.util.concurrent.Callable;

class Jugador implements Runnable {
    private String nom;
    private int numEntrenos;

    public Jugador(String nom, int numPartits) {
        this.nom = nom;
        this.numEntrenos = numPartits;
    }

    @Override
    public void run() {
        // Temps que triga a jugar cada partit entre 100 i 200 milisegons
        System.out.println(nom + " fent entrenaments...");
        try {
            for (int i = 0; i < numEntrenos; i++) {
                Thread.sleep((long) ((Math.random() * 100) + 100));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(nom + " ha acabat de fer els seus entrenaments.");
    }
}