/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rminaming.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import rminaming.shared.MyRemoteObject;


public class MyRemoteObjectImpl extends UnicastRemoteObject implements MyRemoteObject {

    public MyRemoteObjectImpl() throws RemoteException {
        super();
    }
    
    @Override
    public String hello() throws RemoteException{
        return "Hey, hello";
    }
    
}
