package ForkJoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class DivisionTask extends RecursiveTask<Integer> {
    private int n;
    DivisionTask (int n) {
        this.n = n;
    }

    private int DivisionS() {
        return n;
    }

    private int DivisionR() {
        System.out.println("Resta: " + (n));
        DivisionTask d1 = new DivisionTask(n - 3);
        invokeAll(d1);
        return d1.join();
    }

    @Override
    protected Integer compute() {
        if (n < 3) return DivisionS();
        else return DivisionR();
    }


    public static void main(String[] args) {
        int n = 24;
        DivisionTask task = new DivisionTask(n);
        ForkJoinPool pool = new ForkJoinPool();
        pool.submit(task);
        int resultat = task.join();
        System.out.println("Final: " + resultat);
    }
}
