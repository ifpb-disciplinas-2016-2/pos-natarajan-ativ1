/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rminaming.server;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author natarajan
 */
public class RMINamingServer {
    
    public static void main(String[] args) throws AlreadyBoundException {
        
        try {
                        
            LocateRegistry.createRegistry(10998);
            Naming.rebind("//localhost:10998/helloObject", new  MyRemoteObjectImpl()); 
            System.out.println("Server ready");
           
        } catch (RemoteException | MalformedURLException ex) {
            System.err.println("Error on server:");
            Logger.getLogger(RMINamingServer.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
    }
    
}
