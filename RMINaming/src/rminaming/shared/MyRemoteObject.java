/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rminaming.shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author natarajan
 */
public interface MyRemoteObject extends Remote {

    public String hello() throws RemoteException;
    
}
