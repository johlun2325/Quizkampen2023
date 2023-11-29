package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    protected int port = 44456;
    protected String ipAdr = "127.0.0.1";
    PrintWriter out;
    BufferedReader in;
    GameGUI gui;

    public Client(){

        try { Socket socket = new Socket(ipAdr, port);
            out = new PrintWriter(socket.getOutputStream());
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void play () {  //ENABLE
        String fromServer;

        try {

            fromServer = in.readLine();
            if (fromServer.equals("Ansluten")) {
                gui = new GameGUI();
                while (gui.name.isEmpty()) {
                    Thread.sleep(1000);
                }
                out.println("Name:" + gui.name);
                System.out.println("Name sent " + gui.name);
               gui.showCategoryPanel();

            }





        } catch (Exception e) {  //FINALLY
            e.printStackTrace();
        }
    }




    public static void main(String[] args) {
        Client client = new Client();
        client.play();
    }
}