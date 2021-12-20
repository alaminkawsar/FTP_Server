public class Computer2{
    public static void main(String[] args){
        Server server = new Server("Abir", 50001);
        server.start();

        Client client = new Client("Abir", 50000);
        client.start();
    }
    
}
