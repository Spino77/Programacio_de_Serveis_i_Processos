package Threads;

public class Thread extends java.lang.Thread {
    public Thread(String name) {
        super(name);
    }

    @Override
    public void start() {
        System.out.printf("Hola | %s%n",getName());
    }

    public static void main(String[] args) {
        Thread f1 = new Thread("Fil1");
        Thread f2 = new Thread("Fil2");
        Thread f3 = new Thread("Fil3");
        f1.start();
        f2.start();
        f3.start();
    }
}
