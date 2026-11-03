package Examen.Ex1;

public class MainCiutatMagica {
    public static void main(String[] args) {
        Clau c = new Clau();
        System.out.println("El nombre de la profecia es: " + c.valor_profecia);
        Profecia p = new Profecia(c);
        Guardia g = new Guardia(c);

        p.start();
        g.start();
    }
}