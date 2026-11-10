package Act3;

public class Paleta implements Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep((long) (Math.random() * 10000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
