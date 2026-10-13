package Threads;

public class ThreadAct extends java.lang.Thread {
    public ThreadAct(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.printf("Hola | %s%n",getName());
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadAct f1 = new ThreadAct("Fil1");
        ThreadAct f2 = new ThreadAct("Fil2");
        ThreadAct f3 = new ThreadAct("Fil3");
        f1.start();
        f2.start();
        f3.start();
        f1.join();
        f2.join();
        f3.join();


    }
}