import java.io.DataInputStream;
import java.io.IOException;

public class Token_Ring{
    public static void main(String[] args) throws NumberFormatException, IOException {
        DataInputStream dis=new DataInputStream(System.in);
        System.out.println("Enter the No. of Nodes: ");
        int n=Integer.parseInt(dis.readLine());

        int token=0;

        int ch=1;
        for(int i=0;i<n;i++)
        {
            System.out.print(" " + i);
        }
        System.out.println(" " + 0);

        try {
            while(ch==1)
            {
                System.out.println("Enter Sender: ");
                int s=Integer.parseInt(dis.readLine());
                System.out.println("Enter Receiver: ");
                int r=Integer.parseInt(dis.readLine());
                System.out.println("Enter Data: ");
                String d=dis.readLine();
                System.out.println("Token Passing: ");
                for(int i=token;i != s;i++)
                {
                    System.out.print(" "+ i +"->");
                }
                System.out.println(" "+s);

                System.out.println("Sender "+s+" Sending data: "+d);
                for(int i=s+1;i!=r;i=(i+1)%n)
                {
                    System.out.println("data "+d+" forwarded by "+i);

                }
                System.out.println("receiver "+r+" received data: "+d);
                token=s;
                
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}