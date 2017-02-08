/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multicast.receiver;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 *
 * @author natarajan
 */
public class Receiver {
    
    public static void main(String[] args) throws IOException {
        
//        System.setProperty("java.net.preferIPv4Stack", "true");
        
        int mcPort = 6789;
        String mcIPStr = "224.0.0.1";
        
        MulticastSocket mcSocket = null;
        InetAddress mcIPAddress = null;
        mcIPAddress = InetAddress.getByName(mcIPStr);
        mcSocket = new MulticastSocket(mcPort);
        
        System.out.println("Multicast Receiver running at:" + mcSocket.getLocalSocketAddress());
        
        //entrando no grupo multicast
//        mcSocket.joinGroup(mcIPAddress);

        DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);

        System.out.println("Waiting for a  multicast message...");
        mcSocket.receive(packet);
        String msg = new String(packet.getData(), packet.getOffset(),
            packet.getLength());
        System.out.println("[Multicast  Receiver] Received:" + msg);

//        mcSocket.leaveGroup(mcIPAddress);
        mcSocket.close();        
        
    }
    
}
