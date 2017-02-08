/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketudpsimples;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 *
 * @author natarajan
 */
public class Client {
    
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException {
        
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        
        
        try (DatagramSocket clientSocket = new DatagramSocket()) {
            InetAddress IPAddress = InetAddress.getByName("localhost");
            byte[] dadosAEnviar = new byte[1024];
            byte[] dadosRecebidos = new byte[1024];
            
            String mensagem = entrada.readLine();
            dadosAEnviar = mensagem.getBytes();
            
            //Enviar mensagem para o servidor
            DatagramPacket pacoteAEnviar = new DatagramPacket(dadosAEnviar, dadosAEnviar.length, IPAddress, 10999);
            clientSocket.send(pacoteAEnviar);
            
            //Receber resposta
            DatagramPacket receivePacket = new DatagramPacket(dadosRecebidos, dadosRecebidos.length);
            clientSocket.receive(receivePacket);
            String resposta = new String(receivePacket.getData()).trim();
            
            System.out.println("Resposta do Servidor: " + resposta);
        }
        
    }
    
}
