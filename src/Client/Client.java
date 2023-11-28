package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    protected int port = 44456;
    protected String ipAdr = "127.0.0.1";

    public Client(){

        try (Socket socket = new Socket(ipAdr, port);
             PrintWriter out = new PrintWriter(socket.getOutputStream());
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())))
        {
            //läsa och skriva till client och play()

        }
        catch(IOException e){
            e.printStackTrace();
        }

    }




    public static void main(String[] args) {
        new Client();
    }
}