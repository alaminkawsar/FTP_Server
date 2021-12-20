import java.io.*;
import java.net.*;

public class Server implements Runnable{
    private Thread t;
    private String threadName, END = "done";
    private int port;

    Server(String Name, int port){
        threadName = Name;
        this.port = port;
        System.out.println(threadName+": is ready as server");
    }
    @Override
    public void run() {
        try{
            ServerSocket ss = new ServerSocket(port);
            Socket s = ss.accept();

            DataInputStream dis = new DataInputStream(s.getInputStream());

            while(true){
                String text = dis.readUTF();

                if(text.equals(END)){
                    break;
                }
                System.out.println(text);
            }
            ss.close();
        }catch(Exception e){System.out.println(e);}
        

        
    }

    public void start(){
        if(t==null){
            t = new Thread(this,threadName);
            t.start();
        }
    }

}