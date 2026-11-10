package Act2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class ExaminarAlumnes {
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);

        List<Alumne> examinacions = new ArrayList<>();

        for (int i = 0; i < 24; i++) {
            Alumne examinar = new Alumne("nom");
            examinacions.add(examinar);
        }

        List<Future<Integer>> notes;

        notes = executor.invokeAll(examinacions);
        executor.shutdown();

        for (int i = 0; i < notes.size(); i++) {
            Future<Integer> resultat = notes.get(i);
            try {
                System.out.println("Nota d'alumne " + /* examinacions.get(i).getNom() + " " + */ "es: " + resultat.get());
            }
            catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
    }
}