/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multicast.sender;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 *
 * @author natarajan
 */
public class Sender {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        
//        System.setProperty("java.net.preferIPv4Stack", "true");
        
        // join a Multicast group and send the group salutations
        String msg = "Oi, quem tá ai?";
//        InetAddress group = InetAddress.getByName("224.0.0.1");

        InetAddress group = InetAddress.getByName("127.0.0.1");
        MulticastSocket s = new MulticastSocket(6789);
//        s.joinGroup(group);
        DatagramPacket oi = new DatagramPacket(msg.getBytes(), msg.length(), group, 6789);
        s.send(oi);
        
        // get their responses!
        byte[] buf = new byte[1024];
        DatagramPacket recv = new DatagramPacket(buf, buf.length);
        s.receive(recv);
        
        // OK, I'm done talking - leave the group...
        s.leaveGroup(group);
        
        
    }
    
}
