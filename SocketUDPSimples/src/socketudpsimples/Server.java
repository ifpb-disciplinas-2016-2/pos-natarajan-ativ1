/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketudpsimples;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author natarajan
 */
public class Server {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        try {
            DatagramSocket serverSocket = new DatagramSocket(10999);
            byte[] dadosRecebidos = new byte[1024];
            byte[] dadosEnviados = new byte[1024];
            
            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(dadosRecebidos, dadosRecebidos.length);
                serverSocket.receive(receivePacket);
                String recebido = new String( receivePacket.getData()).trim();
                System.out.println("Recebemos sua mensagem: " + recebido);
                
                //Enviando resposta
                //pegar ip e porta do datagrama recebido
                InetAddress IPAddress = receivePacket.getAddress();
                int port = receivePacket.getPort();
                
                String response = "Mensagem Recebida: " + recebido;
                dadosEnviados = response.getBytes();
                
                //montar novo datagrama e enviar para o cliente
                DatagramPacket sendPacket = new DatagramPacket(dadosEnviados, dadosEnviados.length, IPAddress, port);
                serverSocket.send(sendPacket);
                
            }
            
            
        } catch (SocketException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
}
