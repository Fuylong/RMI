/**
 * 
 */
package server;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @author f_756
 *
 */
public class PhoneServer {

    private static void startRegistry(int RMIPortNum) throws RemoteException {
        try {
            Registry registry = LocateRegistry.getRegistry(RMIPortNum);
            registry.list();
        } catch (RemoteException re) {
            System.out.println("RMI Registry cannot be located at port " + RMIPortNum);
            Registry registry = LocateRegistry.createRegistry(RMIPortNum);
            System.out.println("RMI Registry created at port " + RMIPortNum);
        }
    }

    public static void main(String[] args) {
        String portNum = "1234", registryURL;

        try {
            PhoneImpl pImpl = new PhoneImpl();
            startRegistry(1234);
            registryURL = "rmi://localhost:" + portNum + "/phone";
            Naming.rebind(registryURL, pImpl);
        } catch (Exception re) {
            System.out.println("Exception in PhoneImpl.Main:" + re);
        }
    }
}
