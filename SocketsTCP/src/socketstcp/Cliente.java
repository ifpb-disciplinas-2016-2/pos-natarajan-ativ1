/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketstcp;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author Natarajan
 */
public class Cliente {
    public static void main(String[] args) throws IOException, JAXBException {
        //criando mensagem
        Message m = new Message();
        m.setText("Hello!!!");
        m.setName("Natarajan");
        
        //criando o objeto da serialização da mensagem
        JAXBContext ctx = JAXBContext.newInstance(Message.class);
        Marshaller marshaller = ctx.createMarshaller();
        
        //criando o socket
        System.out.println("Cliente: conectando servidor");
        
        try (Socket socket = new Socket("localhost", 10999)) {
            System.out.println("Client: enviando mensagem...");
            
            
            marshaller.marshal(m, socket.getOutputStream());
            
            socket.getOutputStream().flush();   //no flush, quando tudo for enviado é que o programa continua
            //termino do envio e início do recebimento
            
            InputStream input = socket.getInputStream();
            byte[] b = new byte[1024];
            input.read(b);
            
            System.out.println("Resposta: " + new String(b).trim());
        }
    }
}
