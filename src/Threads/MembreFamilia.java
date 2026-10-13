package Threads;

public class MembreFamilia extends Thread{
    Comandament com = new Comandament();

    public MembreFamilia(Comandament com) {
        this.com = com;
    }

    @Override
    public void run() {
        for (;;) {
            //agafar el comandament
            //mirar la televisió
            //deixar el comandament
            //descansar
        }

    }
}

