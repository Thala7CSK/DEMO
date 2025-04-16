
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class AddServerImp extends UnicastRemoteObject implements AddServerIntf{
    public AddServerImp() throws RemoteException{
        
    }

    @Override
    public double add(double d1, double d2) throws RemoteException {
       return d1+d2;
    }
}
