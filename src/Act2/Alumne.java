package Act2;

import java.util.concurrent.Callable;

public class Alumne implements Callable<Integer> {
    private String nom;
    public Alumne(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public Integer call() throws Exception {
        int nota = (int) (Math.random() * 10);
        return nota;
    }
}
