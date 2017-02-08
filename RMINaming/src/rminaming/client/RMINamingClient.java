/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rminaming.client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import rminaming.shared.MyRemoteObject;

/**
 *
 * @author natarajan
 */
public class RMINamingClient {
    
    public static void main(String[] args) {
     
        try {
            MyRemoteObject myRemoteObject = (MyRemoteObject) Naming.lookup("//localhost:10998/helloObject");
            
            System.out.println(myRemoteObject.hello());
            
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(RMINamingClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }
            
    
}
