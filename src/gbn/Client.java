package gbn;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {

    public static void main(String[] args) throws Exception{

        DatagramSocket clientSocket = new DatagramSocket();

        InetAddress IPAdress = InetAddress.getByName("127.0.0.1");

        byte[] sendData = new byte[1024];
        sendData = "sou um cliente".getBytes();

        DatagramPacket sendPkt = new DatagramPacket(sendData, sendData.length, IPAdress, 9876);

        clientSocket.send(sendPkt);



        byte[] rcvBuffer = new byte[1024];
        DatagramPacket rcvPkt = new DatagramPacket(rcvBuffer, rcvBuffer.length);
        clientSocket.receive(rcvPkt);

        String info = new String(rcvPkt.getData(), rcvPkt.getOffset(), rcvPkt.getLength());

        System.out.println(info);

        clientSocket.close();
    }
}
