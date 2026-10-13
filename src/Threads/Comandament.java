package Threads;

public class Comandament {
    private boolean disponible;

    public Comandament() {
        disponible = true;
    }

    //metodes de deixar/agafar

    public void agafar() throws InterruptedException {
        while (!disponible) wait();
        disponible = false;
        notifyAll();
    }

    public void deixar() {
        disponible = true;
        notifyAll();
    }



}
