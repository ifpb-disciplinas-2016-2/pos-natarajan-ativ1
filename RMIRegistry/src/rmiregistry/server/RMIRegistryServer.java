/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiregistry.server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author natarajan
 */
public class RMIRegistryServer {
    
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        
        Registry registry = LocateRegistry.createRegistry(10999);
        registry.bind("remoteobject", new MyRemoteObjectImpl());
        System.out.println("Servidor executando na porta 10999");
        
    }
    
}
