package SocketsAndServices.Act2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;

public class JocServer {
    DatagramSocket socket;
    SecretNum secretNum;

    //Instanciar el socket
    public void init(int port) throws SocketException {
        socket = new DatagramSocket(port);
        this.secretNum = new SecretNum(100);
    }

    public void runServer() throws IOException {
        byte [] receivingData = new byte[4];
        byte [] sendingData;
        InetAddress clientIP;
        int clientPort;

        while(true) {
            DatagramPacket packet = new DatagramPacket(receivingData,4);

            socket.receive(packet);

            clientIP = packet.getAddress();

            sendingData = processData(packet.getData(),packet.getLength());

            //Llegim el port i l'adreça del client per on se li ha d'enviar la resposta
            clientPort = packet.getPort();

            packet = new DatagramPacket(sendingData,sendingData.length,clientIP,clientPort);

            socket.send(packet);
        }
    }

    //El server retorna al client el mateix missatge que li arriba però en majúscules
    private byte[] processData(byte[] data, int lenght) {
        int clientNumber = ByteBuffer.wrap(data).getInt();
        System.out.println(clientNumber);

        int returnValue = secretNum.comprova(clientNumber);
        return ByteBuffer.allocate(4).putInt(returnValue).array();
    }

    public static void main(String[] args) {
        JocServer server = new JocServer();
        try {
            server.init(5555);
            server.runServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
