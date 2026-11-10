package SocketsAndServices.Act1;

import java.io.IOException;
import java.net.*;

public class DatagramSocketClient {
    InetAddress serverIP;
    int serverPort;
    DatagramSocket socket;

    public void init(String host, int port) throws SocketException,
            UnknownHostException {
        serverIP = InetAddress.getByName(host);
        serverPort = port;
        socket = new DatagramSocket();
    }

    public void runClient() throws IOException {
        byte [] receivedData = new byte[1024];
        byte [] sendingData;

        //a l'inici
        sendingData = getFirstRequest();
        //el servidor atén el port indefinidament
        while(mustContinue(sendingData)){
            DatagramPacket packet = new DatagramPacket(sendingData,
                    sendingData.length,
                    serverIP,
                    serverPort);
            //enviament de la resposta
            socket.send(packet);

            //creació del paquet per rebre les dades
            packet = new DatagramPacket(receivedData, 1024);
            //espera de les dades, màxim 5 segons
            socket.setSoTimeout(5000);
            try{
                //espera de les dades
                socket.receive(packet);
                //processament de les dades rebudes i obtenció de la resposta
                sendingData = getDataToRequest(packet.getData(), packet.getLength());
            }catch(SocketTimeoutException e){
                sendingData = timeoutExceded(packet);
            }
        }
    }

    private byte[] getDataToRequest(byte[] data, int length) {
        //procés diferent per cada aplicació

        return data;
    }

    private byte[] getFirstRequest() {
        //procés diferent per cada aplicació
        return null;
    }

    private boolean mustContinue(byte[] sendingData) {
        //procés diferent per cada aplicació
        return false;
    }

    public void close(){
        if(socket!=null && !socket.isClosed()){
            socket.close();
        }
    }
}