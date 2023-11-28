package Server;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerPlayer {
    private ServerPlayer opponent;
    private Socket socket;
    private String player;
    private int point;
    private BufferedReader input;
    private PrintWriter output;


    public ServerPlayer(Socket socket, String player, int point) throws IOException {
        this.socket = socket;
        this.player = player;
        this.point = point;
        try {
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            output = new PrintWriter(socket.getOutputStream(), true);

        } catch (IIOException e) {
            e.printStackTrace();
        }
    }

    public void sendString(String mess) {
        output.println(mess);
    }

    public String receiveString() {
        try {
            return input.readLine();
        } catch (IOException e) {
            System.out.println("Fel i receiveString");
            throw new RuntimeException(e);
        }
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
