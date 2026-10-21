package Threads.TallerCostura;

public class TallerMain {
    public static void main(String[] args) {
        Cistell cistell_manigues = new Cistell(8, true);
        Cistell cistell_cossos = new Cistell(5, true);

        Cosidora cosidora_manigues = new Cosidora(cistell_manigues, "CosidoraManigues");
        Cosidora cosidora_cossos = new Cosidora(cistell_cossos, "CosidoraCossos");

        Encadellador encadellador = new Encadellador("Encadellador", cistell_manigues, cistell_cossos);

        cosidora_manigues.start();
        cosidora_cossos.start();
        encadellador.start();


    }
}
