package Act1;

import java.util.ArrayList;
import java.util.List;

public class MainS {
    public static void main(String[] args) {
        List<MultiplicacioS> llista = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            MultiplicacioS m = new MultiplicacioS((int)(Math.random()*10), (int)(Math.random()*10));
            llista.add(m);
        }

        List<Integer> resultats = new ArrayList<>();
        for (int i = 0; i < llista.size(); i++) {
            resultats.add(llista.get(i).multiplicar());
        }
        for (int i = 0; i < resultats.size(); i++) {
            System.out.println("Resultat tasca " + i + " és: " + resultats.get(i));
        }
    }
}
