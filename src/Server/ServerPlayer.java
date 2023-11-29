package Server;

import javax.imageio.IIOException;
import javax.swing.*;
import java.io.*;
import java.net.Socket;

public class ServerPlayer {
    private ServerPlayer opponent;
    final private Socket socket;
    private String player;
    private int point;
    private BufferedReader stringInput;
    private PrintWriter stringOutput;
    private ObjectOutputStream objectOutput;
    String received;


    public ServerPlayer(Socket socket, String player, int point) {
        this.socket = socket;
        this.player = player;
        this.point = point;
        try {
            objectOutput = new ObjectOutputStream(socket.getOutputStream());
            stringInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //stringOutput = new PrintWriter(socket.getOutputStream(), true);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendObject(Object object) {
        try {
            //objectOutput = new ObjectOutputStream(socket.getOutputStream());
            objectOutput.writeObject(object);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendString(Object mess) throws IOException {
        System.out.println("From ServerPlayer sendString():  " + mess.toString());
        objectOutput.writeObject(mess);
    }

    public String receiveString() {
        try {
            received = stringInput.readLine();
        } catch (IOException e) {
            System.out.println("Fel i receiveString");
            e.printStackTrace();
        }
        // debugg JOptionPane.showMessageDialog(null, "Mess from ServerPlayer.receiveString");
        return received;
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
