import java.rmi.*;
public class AddServer {
    public static void main(String[] args) throws RemoteException {
        AddServerImp addServerImp=new AddServerImp();
        try{
            Naming.rebind("AddServer", addServerImp);
        }
        catch(Exception e){
            System.out.println("Exception: "+e);
        }
    }
}
