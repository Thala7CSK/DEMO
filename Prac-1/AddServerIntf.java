import java.rmi.*;
public interface AddServerIntf extends Remote{
    public double add(double d1,double d2) throws RemoteException;
}