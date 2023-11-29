package Client;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    protected int port = 44456;
    protected String ipAdr = "127.0.0.1";
    PrintWriter out;
    ObjectInputStream in;
    GameGUI gui;

    public Client() {

        try {
            Socket socket = new Socket(ipAdr, port);
            out = new PrintWriter(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void play() {  //ENABLE
        Object fromServer;

        try {
            //fromServer = in.readLine(); ö
            gui = new GameGUI();


            while (true) {
                fromServer = in.readObject();
                System.out.println("Från server" + fromServer);
                if (fromServer.equals("Ansluten")) {
                    //gui = new GameGUI();
                    while (gui.getNameFromGui().isEmpty()) {
                        System.out.println(gui.getNameFromGui());
                        Thread.sleep(5000);
                    }
                    out.println("Name:" + gui.name); //Ev. out.flush() efter
                    out.flush();
                    System.out.println("Name sent " + gui.name);
                } else if (fromServer.equals("Category")) {
                    System.out.println("Client: i kategori");
                    out.println("History");
                    out.flush();
                }
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