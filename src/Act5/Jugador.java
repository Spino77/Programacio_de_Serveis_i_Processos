package Act5;

public class Jugador {
    private String nom;
    private int punts;

    public void addPunts(int punts) {
        this.punts += punts;
    }

    public int getPunts() {
        return punts;
    }

    public String getNom() {
        return nom;
    }
    public Jugador(String nom) {
        this.nom = nom;
    }
}
