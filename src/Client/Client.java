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

    public Client() {

        System.out.println("innan try block");

        try {
            Socket socket = new Socket(ipAdr, port);
            out = new PrintWriter(socket.getOutputStream());
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            System.out.println("inuti try block");
            gui = new GameGUI(); //flyttade gui initieringen hit för att starta spelframe direkt

            //kontinuerlig kommunikation till/från server
            String fromServer;
            String toServer;

            //läser in om inte null
            while ((fromServer = in.readLine()) != null) {

                toServer = play(fromServer);
                out.println(toServer);

            }


        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String play(String fromServer) {  //ENABLE
        System.out.println("inuti play");
        String outString = "";

        switch (fromServer) {

            case "Ansluten" -> {
                while (gui.getNameFromGui().isEmpty())
                    if (!gui.getNameFromGui().isEmpty())
                        outString = gui.getNameFromGui();
            }

            default -> System.out.println("inget giltigt input");
        }
        return outString;
    }


}

//        try {
////            fromServer = in.readLine();
////            if (fromServer.equals("Ansluten")) {
////                while (gui.name.isEmpty()) {
////                    Thread.sleep(1000);
////                }
////                out.println("Name:" + gui.name);
////                System.out.println("Name sent " + gui.name);
//            }
//
//        } catch (Exception e) {  //FINALLY
//            e.printStackTrace();
//        }
        return outString;
                }


public static void main(String[]args){
        Client client=new Client();
//        client.play(); // inte här väl?
        }
        }