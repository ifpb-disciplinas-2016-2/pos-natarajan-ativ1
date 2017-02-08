/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiregistry.client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import rmiregistry.shared.MyRemoteObject;

/**
 *
 * @author natarajan
 */
public class RMIRegistryClient {
    
    public static void main(String[] args) throws RemoteException, NotBoundException {
        
        Registry registry = LocateRegistry.getRegistry("localhost", 10999);
        
        MyRemoteObject myObject = (MyRemoteObject) registry.lookup("remoteobject");
        
        System.out.println(myObject.hello());
        
        
    }
    
}
