package ForkJoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class Fibonacci extends RecursiveTask<Long> {
    private int n;

    Fibonacci(int n) {
        this.n = n;
    }

    public Long FibonacciS() {
        long prev1=0, prev2=1;
        for (int i = 0; i < n; i++) {
            long savePrev1 = prev1;
            prev1 = prev2;
            prev2 = savePrev1 + prev2;
        }
        return prev1;
    }

    public long FibonacciR() {
        Fibonacci f1 = new Fibonacci(n - 1);
        Fibonacci f2 = new Fibonacci(n - 2);
        invokeAll(f1, f2);
        return f1.join() + f2.join();
    }

    @Override
    protected Long compute() {
        if (n < 10) return FibonacciS();
        else return FibonacciR();
    }

    public static void main(String[] args) {
        int n = 9;
        Fibonacci task = new Fibonacci(n);
        ForkJoinPool pool = new ForkJoinPool();
        pool.submit(task);
        Long result = task.join();
        System.out.printf("El fibonacci de %d és %d%n",n,result);
    }
}