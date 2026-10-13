package Threads;

public class CompteEstalvi {
    private float saldo;

    public CompteEstalvi(float saldo) {
        this.saldo = saldo;
    }

    public float getSaldo() {
        return saldo;
    }

    public void ingresar(float diners) {
        float aux;
        aux = getSaldo();
        aux = aux + diners;
        saldo = aux;
    }

    public void treure(float diners) {
        float aux;
        aux = getSaldo();
        aux = aux - diners;
        saldo = aux;
    }
}
