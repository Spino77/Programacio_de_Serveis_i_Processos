package Threads;

import java.util.ArrayList;

public class BancApp {
    public static void main(String[] args) throws InterruptedException {
        CompteEstalvi compte = new CompteEstalvi(1000);
        //TODO 1000 threads que facin ingresar 10 euros al compte
        //TODO 1000 threads que facin treure 5 euros al compte

        ArrayList<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            Thread threadIngressar = new Thread(()->compte.ingresar(10));
            Thread threadTreure = new Thread(()->compte.treure(5));
            threads.add(threadIngressar);
            threads.add(threadTreure);
            threadIngressar.start();
            threadTreure.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Saldo final = " + compte.getSaldo());


    }
}

