/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketstcp;

import com.sun.jmx.remote.internal.Unmarshal;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Natarajan
 */
public class Server {
    public static void main(String[] args) throws IOException, JAXBException {
        
        //criando o objeto de serialização da mensagem
        JAXBContext ctx = JAXBContext.newInstance(Message.class);
        Unmarshaller unmarshaller = ctx.createUnmarshaller();
        
        //criando o servidor e colocando em modo de escuta
        System.out.println("Subindo server");
        try ( ServerSocket serverSocket = new ServerSocket()) {
            serverSocket.bind(new InetSocketAddress(10999));
            
            //o server fica bloqueado aqui
            try (Socket socket = serverSocket.accept() ) {
                System.out.println("Server: cliente conectado...");
                //fazer a leitura do stream
                InputStream input = socket.getInputStream();
                byte[] b = new byte[1024];
                input.read(b);
                String xml = new String(b).trim();
                System.out.println("xml recebido: " + new String(b).trim());
                //imprimindo a mensagme recebida
                Message message = (Message) unmarshaller.unmarshal(new ByteArrayInputStream(xml.getBytes()));
                System.out.println("Mensagem enviada pelo cliente: " + message.getText());
                System.out.println("Cliente: " + message.getName());
                System.out.println("Tamanho da mensagem: " + message.getSize());
                String response = message.getText() + ", " + message.getName();
                socket.getOutputStream().write(response.getBytes());
                //conexão e servidor encerrados
            }
        }   
        
    }
}
