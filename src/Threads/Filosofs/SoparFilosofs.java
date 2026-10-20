package Threads.Filosofs;

public class SoparFilosofs {
    public static void main(String[] args) {
        Cobert c1 = new Cobert(true);
        Cobert c2 = new Cobert(true);
        Cobert c3 = new Cobert(true);

        Filosof f1 = new Filosof(c1, c2, "Filosof1");
        Filosof f2 = new Filosof(c2, c3, "Filosof2");
        Filosof f3 = new Filosof(c3, c1, "Filosof3");

        f1.start();
        f2.start();
        f3.start();

    }
}
