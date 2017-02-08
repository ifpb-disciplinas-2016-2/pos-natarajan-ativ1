/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helloclient;

/**
 *
 * @author natarajan
 */
import hello.Hello;
import hello.HelloHelper;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import java.util.*;

public class HelloClient {

    static Hello helloImpl;

    public static void main(String args[]) {
        try {
            // Create and initialize the ORB.
            ORB orb = ORB.init(args, System.getProperties()); 

            // Get the root naming context.
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            
            // Use NamingContextExt instead of NamingContext. This is 
            // part of the Interoperable Naming Service. 
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            
            // Resolve the Object reference in Naming.
            String name = "Hello";
            helloImpl = HelloHelper.narrow(ncRef.resolve_str(name));
            System.out.println("Obtained a handle on server object: " + helloImpl);
            System.out.println(helloImpl.sayHello());
            helloImpl.shutdown();
           
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
