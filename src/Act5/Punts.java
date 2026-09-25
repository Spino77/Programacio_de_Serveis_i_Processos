package Act5;

public class Punts implements Runnable{
    Jugador jugador;

    public Punts(Jugador jugador) {
        this.jugador = jugador;
    }

    @Override
    public void run() {
        int punts = (int) (Math.random() * 10 + 1);
        System.out.println("Jugador " + jugador.getNom() + ": +" + punts + " punts.");
        jugador.addPunts(punts);
    }
}
