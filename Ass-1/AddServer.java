import java.rmi.*;

public class AddServer {
    public static void main(String[] args) {
        try {
            AddServerImp addServerImp=new AddServerImp();
            Naming.rebind("AddServer", addServerImp);
        } catch (Exception e) {
            System.out.println("Exception: "+ e);
        }
    }
}
