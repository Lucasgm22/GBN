package gbn;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Server {

    public static void main(String[] args) throws Exception {

        DatagramSocket serverSocket = new DatagramSocket(9876);

        while (true) {

            byte[] rcvBuffer = new byte[1024];
            DatagramPacket rcvPkt = new DatagramPacket(rcvBuffer, rcvBuffer.length);
            serverSocket.receive(rcvPkt);
            String info = new String(rcvPkt.getData(), rcvPkt.getOffset(), rcvPkt.getLength());

            System.out.println("recevido do cliente: " + info);

            byte[] sendData = new byte[1024];
            sendData = "sou o servidor".getBytes();

            InetAddress IPAddress = rcvPkt.getAddress();
            int port = rcvPkt.getPort();
            DatagramPacket sendPkt = new DatagramPacket(sendData, sendData.length, IPAddress, port);

            serverSocket.send(sendPkt);
            System.out.println("mensagem enviada");
        }
    }
}


