public class Computer1 {
    public static void main(String[] args){
        Server server = new Server("Alamin", 50000);
        server.start();

        Client client = new Client("Alamin", 50001);
        client.start();
    }
    
}
