import mpi.*;

public class Assign3{
    public static void main(String[] args) throws Exception {
        MPI.Init(args);

        int rank=MPI.COMM_WORLD.Rank();
        int size=MPI.COMM_WORLD.Size();

        int unitsize=5;
        int root=0;
        int send_buffer[]=new int[unitsize*size];
        int receive_buffer[]=new int[unitsize];
        int new_receive_buffer[]=new int[size];

        if(rank==root)
        {
            int total_elements=unitsize*size;
            System.out.println("Enter "+total_elements+" elements");
            for(int i=0;i<total_elements;i++)
            {
                System.out.println("Element "+i+"\t = "+i);
                send_buffer[i]=i;
            }
        }

        MPI.COMM_WORLD.Scatter(send_buffer, 0, unitsize, MPI.INT , receive_buffer, 0, unitsize, MPI.INT, root);

        for(int i=1;i<unitsize;i++)
        {
            receive_buffer[0]+=receive_buffer[i];
        }

        System.out.println("Intermediate sum at process "+ rank +" is "+ receive_buffer[0]);

        MPI.COMM_WORLD.Gather(receive_buffer, 0, 1, MPI.INT, new_receive_buffer, 0, 1, MPI.INT, root);

        if(rank==root)
        {
            int totalsum=0;
            for(int i=0;i<size;i++)
            {
                totalsum+=new_receive_buffer[i];
            }
            System.out.println("Final sum : "+ totalsum);

        }

        MPI.Finalize();
    }
}