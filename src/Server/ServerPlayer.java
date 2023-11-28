package Server;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerPlayer {
    ServerPlayer opponent;
    Socket socket;


    public ServerPlayer(Socket socket) throws IOException {
        this.socket = socket;
    try (BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
         PrintWriter output = new PrintWriter(socket.getOutputStream(), true)
    ) {








    }catch (IIOException e) {
        e.printStackTrace();
    }








    }





}
