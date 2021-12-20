import java.net.Socket;
import java.util.Scanner;
import java.io.*;

public class Client implements Runnable{

    private String threadName;
    private int port;
    Thread t;

    Client(String name,int port){
        threadName = name;
        this.port = port;
    }

    @Override
    public void run() {
        try{
            Thread.sleep(10000);
        }catch(Exception e){}
        System.out.println("Client is Ready");
        try{
            Socket s = new Socket("localhost",port);
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            Scanner input = new Scanner(System.in);
            while(true){
                String msg = input.nextLine();
                dout.writeUTF(msg);
                dout.flush();
                if(msg.equals("done")) break;
                
            }
            input.close();
            dout.close();
            s.close();
        }catch(Exception e){}

        
    }

    public void start(){
        if(t==null){
            t = new Thread(this,threadName);
            t.start();
        }
    }

    
}
