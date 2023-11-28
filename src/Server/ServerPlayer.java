package Server;

import javax.imageio.IIOException;
import java.io.*;
import java.net.Socket;

public class ServerPlayer {
    private ServerPlayer opponent;
    final private Socket socket;
    private String player;
    private int point;
    private BufferedReader stringInput;
    private PrintWriter stringOutput;


    public ServerPlayer(Socket socket, String player, int point) {
        this.socket = socket;
        this.player = player;
        this.point = point;
        try {
            //objectOutput = new ObjectOutputStream(socket.getOutputStream());
            stringInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            stringOutput = new PrintWriter(socket.getOutputStream(), true);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendObject(Object object) {
        try {
            ObjectOutputStream objectOutput = new ObjectOutputStream(socket.getOutputStream());
            objectOutput.writeObject(object);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendString(String mess) {
        stringOutput.println(mess);
    }

    public String receiveString() {
        try {
            return stringInput.readLine();
        } catch (IOException e) {
            System.out.println("Fel i receiveString");
            e.printStackTrace();
        }
        return "Fel i receiver";
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public ServerPlayer getOpponent() {
        return opponent;
    }

    public void setOpponent(ServerPlayer opponent) {
        this.opponent = opponent;
    }
}
