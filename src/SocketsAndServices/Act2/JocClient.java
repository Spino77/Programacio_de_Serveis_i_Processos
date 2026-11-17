package SocketsAndServices.Act2;

import java.io.IOException;
import java.net.*;
import java.nio.ByteBuffer;
import java.util.Scanner;

public class JocClient {
    InetAddress serverIP;
    int serverPort;
    DatagramSocket socket;
    Scanner sc = new Scanner(System.in);

    public void init(String host, int port) throws SocketException, UnknownHostException {
        serverIP = InetAddress.getByName(host);
        serverPort = port;
        socket = new DatagramSocket();
    }

    public void runClient() throws IOException {
        byte [] receivedData = new byte[1024];
        byte [] sendingData;

        sendingData = getFirstRequest();
        while (mustContinue(sendingData)) {
            DatagramPacket packet = new DatagramPacket(sendingData,sendingData.length,serverIP,serverPort);
            socket.send(packet);
            packet = new DatagramPacket(receivedData,1024);
            socket.receive(packet);
            sendingData = getDataToRequest(packet.getData(), packet.getLength());
        }
        socket.close();

    }

    //Resta de conversa que se li envia al server
    private byte[] getDataToRequest(byte[] data, int length) {
        int numberReceived = ByteBuffer.wrap(data).getInt();

        if (numberReceived == 0) {
            System.out.println("Has posat el numero correcte :)");
        } else if (numberReceived == 1) {
            System.out.println("El numero correcte es més petit.");
        } else if (numberReceived == 2) {
            System.out.println("El numero correcte es més gran.");
        }

        System.out.println("Introdueix un numero:");
        return ByteBuffer.allocate(4).putInt(sc.nextInt()).array();
    }

    //primer missatge que se li envia al server
    private byte[] getFirstRequest() {
        System.out.println("Introdueix un numero:");
        return ByteBuffer.allocate(4).putInt(sc.nextInt()).array();
    }

    //Si se li diu adeu al server, el client es desconnecta
    public boolean mustContinue(byte [] data) {
        int numberClose = ByteBuffer.wrap(data).getInt();
        if (numberClose == -1) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        JocClient client = new JocClient();
        try {
            client.init("localhost",5555);
            client.runClient();
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}